package com.danmoop.raidersbay.Manager;

import com.danmoop.raidersbay.Model.Level;

import java.util.Stack;

public class LevelManager
{
    private Stack<Level> levels;

    public LevelManager()
    {
        levels = new Stack<Level>();
    }

    public void open(Level level)
    {
        if (levels.size() == 0)
        {
            levels.add(level);
        }

        else
        {
            levels.pop();

            levels.add(level);
        }

        level.start();
    }

    public Level getActiveLevel()
    {
        return levels.peek();
    }
}