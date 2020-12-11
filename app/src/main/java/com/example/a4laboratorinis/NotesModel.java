package com.example.a4laboratorinis;

public class NotesModel {
    private int id;
    private String noteName;
    private String noteContent;

    public NotesModel(int id, String noteName, String noteContent) {
        this.id = id;
        this.noteName = noteName;
        this.noteContent = noteContent;
    }

    public NotesModel() {
    }

    @Override
    public String toString() {
        return "Title: " + noteName + "\n" +
                "Note: " + noteContent
                ;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNoteName() {
        return noteName;
    }
    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }
    public String getNoteContent() {
        return noteContent;
    }
    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
}
