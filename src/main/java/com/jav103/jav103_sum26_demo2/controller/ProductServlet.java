package com.jav103.jav103_sum26_demo2.controller;

import com.jav103.jav103_sum26_demo2.entity.Category;
import com.jav103.jav103_sum26_demo2.entity.Product;
import com.jav103.jav103_sum26_demo2.services.CategoryServices;
import com.jav103.jav103_sum26_demo2.services.ProductServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = {
        "/products",
        "/product-view",
        "/product-delete",
        "/products/insert",
        "/product-edit",
        "/add-product",
        "/edit-product"
})
public class ProductServlet extends HttpServlet {
    private final ProductServices productServices = new ProductServices();
    private final CategoryServices categoryServices = new CategoryServices();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/products":
                listProduct(request, response);
                break;
            case "/product-delete":
                deleteProduct(request, response);
                break;
            case "/add-product":
                addProductForm(request, response);
                break;
            case "/edit-product":
                editProductFrom(request, response);
                break;
            case "/product-view":
                viewProduct(request, response);
                break;
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            Long id = Long.parseLong(idParam);
            Product product = productServices.getProductById(id);
            request.setAttribute("productDetail", product);
        }
        request.getRequestDispatcher("/views/product/product-detail.jsp").forward(request, response);
    }

    private void editProductFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            Long id = Long.parseLong(idParam);
            Product product = productServices.getProductById(id);
            request.setAttribute("product", product);
        }
        request.setAttribute("categories", categoryServices.getCategories());
        request.getRequestDispatcher("/views/product/edit-product.jsp").forward(request, response);
    }

    private void addProductForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", categoryServices.getCategories());
        request.getRequestDispatcher("/views/product/new-product.jsp").forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nid = request.getParameter("id");
        if (nid != null) {
            Long id = Long.parseLong(nid);
            productServices.deleteProduct(id);
        }
        response.sendRedirect(request.getContextPath() + "/products");
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productServices.getProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/views/product/product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/products/insert":
                insertProduct(request, response);
                break;
            case "/product-edit":
                editProduct(request, response);
                break;
        }
    }

    private Product getProductFromForm(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Long categoryId = Long.parseLong(request.getParameter("categoryId"));

        Category category = new Category();
        category.setId(categoryId);

        return new Product(id, name, price, category);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = getProductFromForm(request);

        if (product.getName() == null || product.getName().trim().isEmpty()) {
            request.setAttribute("errorMessage", "Tên sản phẩm không được để trống");
            request.setAttribute("product", product);
            request.setAttribute("categories", categoryServices.getCategories());
            request.getRequestDispatcher("/views/product/new-product.jsp").forward(request, response);
            return;
        }

        productServices.addProduct(product);
        response.sendRedirect(request.getContextPath() + "/products");
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = getProductFromForm(request);

        if (product.getName() == null || product.getName().trim().isEmpty()) {
            request.setAttribute("errorMessage", "Tên không được để trống");
            request.setAttribute("product", product);
            request.setAttribute("categories", categoryServices.getCategories());
            request.getRequestDispatcher("/views/product/edit-product.jsp").forward(request, response);
            return;
        }

        productServices.editProduct(product);
        response.sendRedirect(request.getContextPath() + "/products");
    }
}
