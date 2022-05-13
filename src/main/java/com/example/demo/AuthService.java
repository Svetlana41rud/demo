package com.example.demo;

import java.io.Closeable;
import java.io.IOException;

public interface AuthService extends Closeable {
    String getNickByLoginAndPassword(String login, String password);

    void run();

    @Override
    void close() throws IOException;
}
