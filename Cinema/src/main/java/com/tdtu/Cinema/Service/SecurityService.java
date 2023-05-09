package com.tdtu.Cinema.Service;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String sdt, String password);
}