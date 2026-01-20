package com.alperen.zkmini;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class CounterVM {

    private int count = 0;

    public int getCount() {
        return count;
    }

    @Command
    @NotifyChange("count")
    public void increase() {
        count++;
    }
}
