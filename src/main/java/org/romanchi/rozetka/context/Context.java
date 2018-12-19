package org.romanchi.rozetka.context;

import org.romanchi.rozetka.Rozetka;

public interface Context {
    void execute();
    void setRozetka(Rozetka rozetka);
}
