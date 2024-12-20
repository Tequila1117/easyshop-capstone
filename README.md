# EASY SHOP Capstone 🛒 

## Summary

EASY SHOP is a website where users can search products, add them to a shopping cart, and check out. Version 1 of the website is fully functional on the front end, and my task was to fix some bugs and implement missing backend functionality in the Spring Boot Java API.

## Features

The backend API includes:

- User registration and login 
- Displaying products by category
- Search and filtering of products

## Bugs 

- **Search/Filter Bug:** The search and filter features were returning incorrect results.
- **Product Duplication Bug:** Products were being duplicated when administrators tried to update them.

## Phase 1: CategoriesController Implementation



I implemented the missing methods in the CategoriesController class, which had been created but not yet functional. I added the necessary annotations and called the methods to handle category functions.

Ex: Only users with the ADMIN role are allowed to perform actions like adding, updating, or deleting categories.

<img width="575" alt="UPDATEandDELETE" src="https://github.com/user-attachments/assets/108f4bfb-938f-4965-94b1-3375f51c9da1" />


<img width="445" alt="callmethods" src="https://github.com/user-attachments/assets/eb8af01b-ecf6-43a8-be5f-4925c7b630eb" />





Changes:
- Implemented methods for CRUD operations (Create, Read, Update, Delete) for categories.

- Ensured that only ADMIN users can use features that update/delete the categories.
Used MySqlCategoriesDao for database operations and followed the Category model.


# Phase 2: Bug Fixes

I fixed two  bugs with the products functionality. There was a search/filter issue and a product duplication problem.

## 1. Search Bug Fix:

   Users had reported that the product search functionality was returning incorrect results, especially when filtering by category or price range. The max parameter needed to be added.
   
   
   <img width="347" alt="Product bug" src="https://github.com/user-attachments/assets/77780066-f658-4ea9-9395-2b3629ab0011" />

   

Fix Details:
The search URL accepts query parameters for category, color, and price range:


<img width="434" alt="ProductSearch" src="https://github.com/user-attachments/assets/e833b77f-b450-4729-967c-55082241e802" />





I updated the search logic to correctly filter products based on the provided criteria, ensuring accurate and relevant results.

## 2. Product Duplication Bug Fix:

   Another reported issue was product duplication during updates. When administrators attempted to update a product, a new record was being created in the database instead of modifying the existing one. I identified the issue and fixed it.

**Fix Details:**

- When an users update a product, the correct product is updated. This prevents duplicates in the database and ensures that the existing product’s details (like price, description, etc.) are correctly updated.
Development Notes
I focused on implementing backend functionality using Spring Boot.
Ensured that only ADMIN users have permission to create/delete products and categories.



## Testing

- I tested all functionality using java script to ensure the results were passed.

<img width="749" alt="PASStest1" src="https://github.com/user-attachments/assets/0a23837c-dbbe-4f6e-99ad-ec92a9dc4dda" />

<img width="748" alt="PASStest2" src="https://github.com/user-attachments/assets/a6b6a264-4728-4f77-a2a5-7bf3d8324c08" />



