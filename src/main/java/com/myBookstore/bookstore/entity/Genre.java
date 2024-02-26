package com.myBookstore.bookstore.entity;

public enum Genre {

    NON_FICTION("Non Fiction"),
    GRAPHIC_NOVEL("Graphic Novel"),
    FICTION("Fiction"),
    MYSTERY_THRILLER("Mystery Thriller"),
    ROMANCE("Romance"),
    SCIENCE_FICTION("Science Fiction"),
    FANTASY("Fantasy"),
    CLASSIC("Classic"),
    HISTORICAL("Historical"),
    YOUNG_ADULT("Young Adults");

    private final String displayValue;

    private Genre(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
