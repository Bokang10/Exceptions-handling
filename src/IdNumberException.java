/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MY PC
 */public class IdNumberException extends Exception {
    // Constructor with a string parameter
    public IdNumberException(String error) {
        super("Invalid Identity number: " + error);
    }
}
