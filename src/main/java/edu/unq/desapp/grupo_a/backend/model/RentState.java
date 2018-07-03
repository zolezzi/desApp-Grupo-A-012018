package edu.unq.desapp.grupo_a.backend.model;

public enum RentState {

    Initial("Initial", "rent.state.initial", ""),
    Canceled("Canceled", "rent.state.canceled", ""),
    WithdrawPreconfirmed("WithdrawPreconfirmed", "rent.state.withdrawPreconfirmed", ""),
    WithdrawConfirmed("WithdrawConfirmed", "rent.state.withdrawConfirmed", ""),
    ReturnPreconfirmed("ReturnPreconfirmed", "rent.state.returnPreconfirmed", ""),
    ReturnConfirmed("ReturnConfirmed", "rent.state.returnConfirmed", "");

    String description;
    String i18nCode;
    String userEmail;

    private RentState(String description, String i18nCode, String userEmail) {
        this.description = description;
        this.i18nCode = i18nCode;
        this.userEmail = userEmail;
    }
}