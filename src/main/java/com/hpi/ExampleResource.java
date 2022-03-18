package com.hpi;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.sun.activation.viewers.TextViewer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Random;
import java.util.Scanner;

import static com.hpi.Choose.*;


@Path("/nano")
public class ExampleResource {

    @POST
    @Path("getId")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("choose") Choose choose,@QueryParam("choosesize") Integer choosesize) {// QueryParam cho phép chọn biến enum nào muốn ra
        String id = "";                                                       //Integer hàm như int nhưng có thể null
        Random random = new Random();
        if(choosesize==null){
            choosesize=20;
        }
        switch (choose) {
            case NUMBER_STRING:
                char[] alphabet = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
                id = NanoIdUtils.randomNanoId(random, alphabet, choosesize);
                System.out.println(id);
                break;
            case STRING:
                char[] alphabetandnumber = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
                id = NanoIdUtils.randomNanoId(random, alphabetandnumber, choosesize);
                System.out.println(id);
                break;
            case NUMBER:
                char[] number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
                id = NanoIdUtils.randomNanoId(random, number, choosesize);
                System.out.println(id);
                break;
            default:
                break;
        }
        return id;
    }
}




