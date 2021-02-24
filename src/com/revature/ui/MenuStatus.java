package com.revature.ui;

public abstract class MenuStatus {
    public enum MenuDepth{
        ROOT
    }

    public static MenuDepth menuDepth = MenuDepth.ROOT;
}