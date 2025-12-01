# Overview
StarMart3 is an Android application designed to enhance the shopping experience by allowing users to select items based on different seasons and compile a shopping list. This application features a user-friendly interface with interactive buttons and media playback for an engaging user experience.

## Created By: Joey Jimenez, Derick Gomez and Valerie Salinas

# Features
Welcome Screen: The main entry point of the application that navigates users to the season selection screen.

Season Selection: Allows users to choose a shopping season, displaying relevant categories for each season.

Item List: Displays items available for the selected season, with options to view details and select items for purchase.

Shopping List: Summarizes the selected items, allowing users to adjust quantities and view the total cost.


# Installation

Clone the repository to your local machine.

Open the project in Android Studio.

Build the project to ensure all dependencies are resolved.

Deploy the application to an Android device or emulator.


# Usage

## MainActivity

Displays the welcome screen.

Plays a mouse click sound when the start button is pressed.

Navigates to the SeasonSelectionActivity.


## SeasonSelectionActivity
Displays buttons for each season.

Reads season data from a CSV file.

Plays a mouse click sound when a season button is pressed.

Navigates to the ItemListActivity with the selected season code.


## ItemListActivity
Displays items for the selected season.

Reads item data from a CSV file.

Allows users to view item details, select items, and adjust quantities.

Navigates to the ShoppingListActivity with the selected items.


## ShoppingListActivity

Displays the selected items with their quantities.

Allows users to adjust item quantities and see the updated total cost.

Navigates back to the SeasonSelectionActivity after purchase.


## CSVReader

Utility class for reading and parsing CSV files.

Provides methods to read season and item data from CSV files in the assets folder.
