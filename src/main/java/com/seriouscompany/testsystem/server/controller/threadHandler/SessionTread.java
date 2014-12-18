//package com.seriouscompany.testsystem.server.controller.threadHandler;
//
//import com.seriouscompany.testsystem.server.main.TestRepository;
//import com.seriouscompany.testsystem.server.entities.user.User;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//import java.util.Observable;
//import java.util.Observer;
//
///**
// *
// * @author Igor
// */
//public class SessionTread extends Thread implements Observer {
//
//    private Socket incoming;
//    private User currentUser;
//    private TestRepository testRepository = TestRepository.getInstance();
//    private ObjectOutputStream outStream;
//    private ObjectInputStream inStream;
//
//    @Override
//    public void update(Observable o, Object arg) {
//    }
//}
