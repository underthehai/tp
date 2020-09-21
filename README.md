## Table of Contents
* [Introduction](#introduction)
* [Setting Up](#setting-up)
* [Command Summary](#command-summary)
* [Tags](#tags)
    * [Activity Tag](#activity-tag)
    * [Accommodation Tag](#accommodation-tag)
    * [Person Tag](#person-tag)
    * [Travel Plan Tag](#travel-plan-tag)
    * [Wishlist Tag](#wishlist-tag)
* [Features](#features)
    * [Goto](#goto)
        1. [Goto a Travel Plan (G)](#1-goto-a-travel-plan-g)
        2. [Goto Wishlist (G)](#2-goto-wishlist-g)
    * [Add](#add)
        1. [Adding a Travel Plan (G)](#1-adding-a-travel-plan-g)
        2. [Adding an Activity (L)](#2-adding-an-activity-l)
        3. [Adding an Accommodation (L)](#3-adding-an-accommodation-l)
        4. [Adding a Person (L)](#4-adding-a-person-l)
    * [Delete](#delete)
        1. [Deleting a Travel Plan (G)](#1-deleting-a-travel-plan-g)
        2. [Deleting an Activity (L)](#2-deleting-an-activity-l)
        3. [Deleting an Accommodation (L)](#3-deleting-an-accommodation-l)
        4. [Deleting a Person (L)](#4-deleting-a-person-l)
    * [Edit](#edit)
        1. [Editing a Travel Plan (G)](#1-editing-a-travel-plan-g)
        2. [Editing an Activity (L)](#2-editing-an-activity-l)
        3. [Editing an Accommodation (L)](#3-editing-an-accommodation-l)
        4. [Editing a Person (L)](#4-editing-a-person-l)
    * [Show](#show)
        1. [Viewing the Wishlist (G)](#1-viewing-the-wishlist-g)
        2. [Viewing Activities in a Travel Plan (G)](#2-viewing-activities-in-a-travel-plan-g)
        3. [Viewing Contacts in a Travel Plan (L)](#3-viewing-contacts-in-a-travel-plan-l)
        4. [Viewing Accommodations in a Travel Plan (L)](#4-viewing-accommodations-in-a-travel-plan-l)
        5. [Viewing Activities in current directory (L)](#5-viewing-activities-in-current-directory-l)
* [FAQ](#faq)

## Show

### 1. Viewing the Wishlist (G)

Shows the list of activities added to the wishlist, in the order they were added.

Format: `show wishlist`

Example: `show wishlist`


### 2. Viewing Activities in a Travel Plan (G)

Shows the list of activities added to a travel plan, in the order they were added.

Format: `show NAME_OF_TRAVEL_PLAN`

Example: `show Europe Plan`

### 3. Viewing Contacts in a Travel Plan (L)

Shows the list of contacts added to the travel plan, in order they were added. <br />
_This command can only be used within a travel plan. Use `goto NAME_OF_TRAVEL_PLAN` before accessing contacts._

Format:
```
goto NAME_OF_TRAVEL_PLAN 
show contacts
```
Example: 
```
goto Europe Plan
show contacts
```

### 4. Viewing Accommodations in a Travel Plan (L)

Shows the list of accommodations added to the travel plan, in order they were added.
_This command can only be used within a travel plan. Use `goto NAME_OF_TRAVEL_PLAN` before accessing accommodations._
   
Format:
```
goto NAME_OF_TRAVEL_PLAN 
show accommodations
```
Example:
```
goto Europe Plan
show accommodations
```

### 5. Viewing Activities in current directory (L)
Shows the list of activities added to the wishlist / travel plan of the current directory, in order they were added.

Format: `show`

Example: `show`

## FAQ
Coming soon!