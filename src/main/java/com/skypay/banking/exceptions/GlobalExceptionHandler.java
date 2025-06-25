package com.skypay.banking.exceptions;

import com.skypay.banking.exceptions.account.AccountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Gestionnaire global des exceptions pour l'application bancaire.
 * Permet de retourner des réponses HTTP appropriées en cas d'erreur métier ou technique.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Gère les exceptions métier liées aux comptes bancaires.
     * Retourne un code 400 (BAD REQUEST) avec le message d'erreur.
     */
    @ExceptionHandler(AccountException.class)
    public ResponseEntity<String> handleAccountException(AccountException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    /**
     * Gère toutes les autres exceptions non prévues.
     * Retourne un code 500 (INTERNAL SERVER ERROR) avec un message générique.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal error: " + ex.getMessage());
    }
} 