/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileTool {

   public static String read(String fileName) {
       StringBuilder content = new StringBuilder();
       try (FileInputStream fileInput = new FileInputStream(fileName);
               InputStreamReader inputStreamReader = new InputStreamReader(fileInput);) {
           while (inputStreamReader.ready()) {
               content.append((char) inputStreamReader.read());
           }
       } catch (IOException ex) {
       }
       return content.toString();
   }

   public static boolean write(String fileName, String content) {
       try (FileOutputStream fileOutput = new FileOutputStream(fileName);) {
           fileOutput.write(content.getBytes());
       } catch (IOException ex) {
           return false;
       }
       return true;
   }
}