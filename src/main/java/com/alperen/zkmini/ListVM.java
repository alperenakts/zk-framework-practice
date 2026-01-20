package com.alperen.zkmini;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.Messagebox;
import com.alperen.zkmini.service.UserService;
import com.alperen.zkmini.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ListVM {

    private String name;                 // UI’dan gelen tek değer
    private RoleType role;
    private UserRole selectedUser;
    private UserService userService = new UserServiceImpl();
    // UI textbox buraya bağlanacak
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Command
    @NotifyChange({"users", "name", "role"})
    public void addUser() {

        if (name == null || name.trim().isEmpty() || role == null) {
            Messagebox.show(
                    "İsim ve rol zorunludur.",
                    "Uyarı",
                    Messagebox.OK,
                    Messagebox.EXCLAMATION
            );
            return;
        }

        UserRole newUser = new UserRole(name.trim(), role);

        if (userService.exists(newUser)) {
            Messagebox.show(
                    "Bu kişi bu rol ile zaten ekli.",
                    "Uyarı",
                    Messagebox.OK,
                    Messagebox.EXCLAMATION
            );
            return;
        }

        userService.addUser(newUser);
        name = "";
        role = null;
    }





    public RoleType getRole() {
        return role;
    }
    public void setRole(RoleType role) {
        this.role = role;
    }

    public List<UserRole> getUsers() {
        return userService.getAll();
    }


    public UserRole getSelectedUser() {
        return selectedUser;
    }
    public void setSelectedUser(UserRole selectedUser) {
        this.selectedUser = selectedUser;
    }


    @Command
    public void deleteSelected() {

        if (selectedUser == null) return;

        Messagebox.show(
                selectedUser.getName() + " - " + selectedUser.getRole().getLabel() + " silinsin mi?",
                "Onay",
                Messagebox.YES | Messagebox.NO,
                Messagebox.QUESTION,
                event -> {
                    if (Messagebox.ON_YES.equals(event.getName())) {
                        userService.deleteUser(selectedUser);
                        selectedUser = null;
                        org.zkoss.bind.BindUtils.postNotifyChange(null, null, this, "users");
                        org.zkoss.bind.BindUtils.postNotifyChange(null, null, this, "selectedUser");
                    }
                }
        );
    }

    public RoleType[] getRoleTypes() {
        return RoleType.values();
    }

}

