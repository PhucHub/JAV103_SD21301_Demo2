package com.jav103.jav103_sum26_demo2.controller;

import com.jav103.jav103_sum26_demo2.entity.Movie;
import com.jav103.jav103_sum26_demo2.services.MovieServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MovieServlet", value = {"/movies", "/movie-view", "/movie-delete", "/movie-add-form", "/movies/insert", "/movie-edit", "/movie-edit-form"})
public class MovieServlet extends HttpServlet {

    private final MovieServices sv = new MovieServices();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        switch (path) {
            case "/movies":
                listMovies(request, response);
                break;
            case "/movie-view":
                viewMovie(request, response);
                break;
            case "/movie-delete":
                deleteMovie(request, response);
                break;
            case "/movie-add-form":
                addForm(request, response);
                break;
            case "/movie-edit-form":
                editForm(request, response);
                break;
        }
    }

    private void listMovies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Movie> movies = sv.getMovies();
        request.setAttribute("movies", movies);
        request.getRequestDispatcher("/views/movie/movie.jsp").forward(request, response);
    }

    private void viewMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            Long id = Long.parseLong(idStr);
            Movie movie = sv.getMovieById(id);
            request.setAttribute("movieDetail", movie);
        }

        request.getRequestDispatcher("/views/movie/movie-detail.jsp").forward(request, response);
    }

    private void deleteMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nid = request.getParameter("id");
        if (nid != null) {
            Long id = Long.parseLong(nid);
            sv.deleteMovie(id);
        }

        response.sendRedirect(request.getContextPath() + "/movies");
    }

    private void addForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/movie/new-movie.jsp").forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam != null) {
            Long id = Long.parseLong(idParam);
            Movie movie = sv.getMovieById(id);

            request.setAttribute("movie", movie);
        }

        request.getRequestDispatcher("/views/movie/edit-movie.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/movies/insert":
                insertMovie(request, response);
                break;

            case "/movie-edit":
                editMovie(request, response);
                break;
        }
    }

    private void insertMovie(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Movie movie = getMovieFromForm(request);

        if (movie.getTitle() == null || movie.getTitle().trim().isEmpty()) {
            request.setAttribute("errorMessage", "Tên phim không được để trống");
            request.setAttribute("movie", movie);

            request.getRequestDispatcher("/views/movie/new-movie.jsp").forward(request, response);
            return;
        }
        sv.addMovie(movie);

        response.sendRedirect(request.getContextPath() + "/movies");
    }

    private Movie getMovieFromForm(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        Long id = (idStr != null && !idStr.trim().isEmpty()) ? Long.parseLong(idStr) : null;
        String title = request.getParameter("title");
        String director = request.getParameter("director");
        String genre = request.getParameter("genre");

        String releaseYearStr = request.getParameter("releaseYear");
        Integer releaseYear = (releaseYearStr != null && !releaseYearStr.trim().isEmpty()) ? Integer.parseInt(releaseYearStr) : null;

        String ratingStr = request.getParameter("rating");
        Double rating = (ratingStr != null && !ratingStr.trim().isEmpty()) ? Double.parseDouble(ratingStr) : null;

        String status = request.getParameter("status");

        return new Movie(id, title, director, genre, releaseYear, rating, status);
    }

    private void editMovie(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Movie movie = getMovieFromForm(request);

        if (movie.getTitle() == null || movie.getTitle().trim().isEmpty()) {
            request.setAttribute("errorMessage", "Tên phim không được để trống");
            request.setAttribute("movie", movie);

            request.getRequestDispatcher("/views/movie/edit-movie.jsp").forward(request, response);
            return;
        }

        sv.editMovie(movie);

        response.sendRedirect(request.getContextPath() + "/movies");
    }
}
