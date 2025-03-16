# Recipe App
This is a sample application consisting of two screens namely, ***recipes listing*** and ***recipe details*** using ***Jetpack Compose***, ***Clean Architecture*** and ***Hilt***.

## Table of Contents
1. [Overview](#overview)
2. [Features](#features)
3. [Architecture](#architecture)
4. [Videos](#videos)

## Overview
***Recipe App*** is a sample android app that fetches the data from ***recipes.json*** file and then displays the list of recipes to the user, when the user clicks on a recipe then he is navigated to the Recipe Details screen. The App also supports accessibility along with landscape and portrait view, also talkback to some extent

## Features
- ***Recipe List***: Displays a list of recipes (recipe image, name of recipe)
- ***Recipe Detail***: Displays the details of the recipe (recipe name, recipe description, recipe image, recipe making details, ingredients)

## Architecture
- **Clean Architecture**:
  - **Data** layer: Repositories and data sources (JSON parsing).
  - **Domain** layer: Domain models.
  - **UI/Presentation** layer: ViewModels + Compose screens.
- **MVVM**:
  - ViewModels handle logic, composables render state.
- **Hilt**:
  - Modules providing dependencies.
- **Coroutines & Flow**:
  - Asynchronous data fetching, real-time updates.

 ## Videos
Here re some videos of the app supporting portrait and landscape modes

https://github.com/user-attachments/assets/21798344-03ec-429c-9158-6d2c802ba128

https://github.com/user-attachments/assets/a6c2f0ca-9d6a-4aea-b7be-3c2d13dd6e2d

https://github.com/user-attachments/assets/8a9a6150-5476-4734-9314-6893a5fb344e

https://github.com/user-attachments/assets/779f52d6-2deb-442e-9b6a-14cb43bea2bd

https://github.com/user-attachments/assets/dfe509f4-855c-4ecf-b31d-672d46656794





     




