package com.babar.app;

import com.babar.ClientService;

/**
 * @author babar
 * @since 2/26/17.
 */
public class MainApp {

    public static void main(String[] args) {
        ClientService service = new ClientService();
        service.init();
        //service.updateClient();
    }
}
