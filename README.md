# Overview
StarMart3 allows players to select in game items based on seasons, access detailed descriptions, and compile a shopping list for planning purchases. The app provides a user friendly, interactive interface with media effects inspired by Stardew Valley.

## Created By: Valerie Salinas and Derick Gomez

The goal of StarMart3 is to provide players with a quick and easy way to access item information in Stardew Valley. Players can identify the best items to purchase for each season, understand how to use them effectively, and manage a shopping list with total cost calculations. 
For example: Potato Seeds – "Plant in spring. Takes 6 days to mature and may yield multiple potatoes at harvest."
The app also encourages planning in-game purchases without interrupting gameplay.

# Installation

Clone the repository to your local machine.

Open the project in Android Studio.

Build the project to ensure all dependencies are resolved.

Deploy the application to an Android device or emulator.


## Features
**1. Welcome Screen**
- Stardew Valley themed menu with a Start button.
- Plays a click sound on button press.
- Navigates to the Season Selection screen.

**2. Season Selection Screen**
- Choose a season: Spring, Summer, Fall, or Year-Round Stock.
- SDV themed UI with familiar characters and fonts.
- Season selection navigates to the Item List screen.

**3. Item List / Selection Screen**
- Scrollable list of items with images, names, prices, and descriptions.
- Items can be added to the shopping list via checkboxes.
- Click on item images for detailed pop ups with additional info (e.g., planting tips, growth time).
- Add to Shopping List button navigates to the final screen.

**4. Shopping List Screen**
- Displays selected items with quantity controls.
- Shows dynamic total cost as quantities are adjusted.
- Background features in game imagery.
- Allows navigation back to season selection for modifications.

## Usage
**MainActivity**
- Displays the welcome screen.
- Plays a click sound on start button.
- Navigates to SeasonSelectionActivity.
  
**SeasonSelectionActivity**
- Shows season buttons.
- Reads data from CSV files.
- Navigates to ItemListActivity with selected season.
  
**ItemListActivity**
- Displays items for the selected season.
- Allows scrolling, viewing details, and selecting items.
- Navigates to ShoppingListActivity with selected items.
  
**ShoppingListActivity**
- Shows selected items and quantities.
- Updates total cost dynamically.
- Returns to season selection if needed.

## CSVReader
Utility class to read CSV files from assets.
Parses season and item data for use in activities.

## Project Goals
Provide an easy to-use mobile companion for Stardew Valley.
Help players identify the best items to buy by season.
Offer item details, including planting tips, prices, and descriptions.
Allow users to create a shopping list with total cost for planning.

## Real Life Application
StarMart3 improves in-game efficiency:
- Players can quickly check if crops grow in the current season.
- Helps plan purchases without unnecessary trips to the in-game General Store.
- Allows estimating total gold needed for items.
- Enhances gameplay experience by saving time and effort.

## CSVReader

Utility class for reading and parsing CSV files.

Provides methods to read season and item data from CSV files in the assets folder.

## Screenshots of Prototype

<img width="246" height="536" alt="image" src="https://github.com/user-attachments/assets/657b49a0-c839-4eed-b5fb-15c0074b79fb" />
<img width="246" height="536" alt="image" src="https://github.com/user-attachments/assets/4da1789e-6567-494f-bdc8-744d5bb18c41" />
<img width="246" height="536" alt="image" src="https://github.com/user-attachments/assets/569c6ef6-6e1d-4df2-884e-0dbfa5216c32" />
<img width="246" height="536" alt="image" src="https://github.com/user-attachments/assets/e4f4398b-2825-4504-afac-63e6b34f2e52" />


## Adobe XD to View Prototype

https://xd.adobe.com/view/4f272917-c4fd-4930-bc74-233e0db32aad-1a74/

## Demo Video of App 

https://www.youtube.com/watch?v=Wi1cxbDjvnQ
