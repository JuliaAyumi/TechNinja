package br.com.fatec.techninja.model;

import java.util.List;

class User {
    private String profilePicture;
    private List<QuizScore> quizScores;
    private String accountLevel;
    private String email;
    private String username;
    private List<CompletedQuiz> completedQuizzes;

    public String getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    public List<QuizScore> getQuizScores() {
        return quizScores;
    }
    public void setQuizScores(List<QuizScore> quizScores) {
        this.quizScores = quizScores;
    }
    public String getAccountLevel() {
        return accountLevel;
    }
    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public List<CompletedQuiz> getCompletedQuizzes() {
        return completedQuizzes;
    }
    public void setCompletedQuizzes(List<CompletedQuiz> completedQuizzes) {
        this.completedQuizzes = completedQuizzes;
    }


}

class QuizScore {
    private String quizTheme;
    private int quizScore;

    public QuizScore(String quizTheme, int quizScore) {
        this.quizTheme = quizTheme;
        this.quizScore = quizScore;
    }

    public String getQuizTheme() {
        return quizTheme;
    }

    public void setQuizTheme(String quizTheme) {
        this.quizTheme = quizTheme;
    }

    public int getQuizScore() {
        return quizScore;
    }

    public void setQuizScore(int quizScore) {
        this.quizScore = quizScore;
    }
}

class CompletedQuiz {
    private String quizTheme;
    private String quizDifficulty;
    private int quizScore;
    public String getQuizTheme() {
        return quizTheme;
    }
    public void setQuizTheme(String quizTheme) {
        this.quizTheme = quizTheme;
    }
    public String getQuizDifficulty() {
        return quizDifficulty;
    }
    public void setQuizDifficulty(String quizDifficulty) {
        this.quizDifficulty = quizDifficulty;
    }
    public int getQuizScore() {
        return quizScore;
    }
    public void setQuizScore(int quizScore) {
        this.quizScore = quizScore;
    }

  
}