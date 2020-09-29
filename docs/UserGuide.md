---
layout: page
title: User Guide
---
# Wanderlust v1.2 User Guide

## Introduction

WanderLust helps tech-savvy travellers to plan their trips in a structured and efficient manner by providing them with a holistic travel planner.
It is optimized for CLI users so that destinations and details can be added faster by typing in commands.

--------------------------------------------------------------------------------------------------------------------

## Table of Contents
* [Introduction](#introduction)
* [Setting Up \[Coming soon\]](#setting-up-coming-soon)
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
* [FAQ \[Coming soon\]](#faq-coming-soon)

--------------------------------------------------------------------------------------------------------------------

## Setting up [Coming soon]

--------------------------------------------------------------------------------------------------------------------
## Command Summary

There are a total of 5 general commands.
The table briefly describes the commands and its usage. Full details will be given in the next section.

Command | Parameters | Description
------------ | ------------- | -------------
`add -OBJECT` | `OBJECT` activity/ accommodation/ person/ travelplan | Creates the given object type
`delete -OBJECT` | `OBJECT` activity/ accommodation/ person/ travelplan | Deletes the given object type
`edit -OBJECT` | `OBJECT` activity/ accommodation/ person/ travelplan | Edits the details of the given object type
`goto PLAN_NAME` | `PLAN_NAME` nameOfTravelPlan/ wishlist | Navigate to the specific travel plan/ wishlist
`show LIST_OF_OBJECTS` | `LIST_OF_OBJECTS` wishlist / nameOfTravelPlan / contacts / accommodation / \<empty\> / | Show the specific list of objects given. If \<listOfObjects\> is empty, WanderLust will show the current travel plan the user is at.

--------------------------------------------------------------------------------------------------------------------
## Tags

The table below shows the type of tag each different object can be assigned to.
Do note that tags are optional when creating the object.

#### Activity Tag
Name of Tag | Description
------------ | -------------
`l/LOCATION` | Location/ Address of the activity.
`i/LEVEL_OF_IMPORTANCE` | The priority assigned to the activity.
`c/cost` | Cost of the activity, if any.
`d/DATE_AND_TIME` | Date and Time intended to do the activity. Format of date is in DD-MM-YYYY and format of time is HHMM (24h clock).


#### Accommodation Tag
Name of Tag | Description
------------ | -------------
`l/LOCATION` | Location/ Address of the accommodation.
`n/NIGHTS` | Number of nights to be spent in the accommodation.
`c/cost` | Cost of the accommodation, if any.

#### Person Tag
Name of Tag | Description
------------ | -------------
`m/MOBILE_NUMBER` | Mobile number of the person cell phone
`p/PASSPORT_NUMBER` | Passport number of the person passport

#### Travel Plan Tag
Name of Tag | Description
------------ | -------------
`sd/START_DATE` | Start date of travel in the format of DD-MM-YYYY
`ed/END_DATE | End date of travel in the format of DD-MM-YYYY

#### Wishlist Tag
Name of Tag | Description
------------ | -------------
`l/LOCATION` | Location/ Address of the activity.
`i/LEVEL_OF_IMPORTANCE` | The priority assigned to the activity.
`c/cost` | Cost of the activity, if any.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add -activity n/NAME`, `NAME` is a parameter which can be used as `add -activity n/Cultural Visit`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [l/LOCATION]` can be used as `n/Cultural Visit l/Lourve Museum` or as `n/Cultural Visit`.

</div>

## Goto

The goto command is used to navigate to various directories within the travel planner. The GUI display depends on the
state of the current directory, which is changed using the goto command. On start, the default directory of the program
is `wishlist`.<br/>
<br/>

>Directories in Wanderlust include:
>1. `wishlist`
>2. `NAME_OF_TRAVEL_PLAN`<br/>

<br/>
This allows users to easily add, delete, view and edit information within the wishlist or a specific travel plan without
having to type their names in each command. This also means that **some commands can only be used locally within a
certain directory, and responses to these commands will depend on the current directory.** Commands that can be used
globally and locally are tagged (G) and (L) respectively in the **features section** of this user guide. <br/>
<br/>

### 1. Goto a Travel Plan (G)
Navigates the UI to a specific travel plan.<br/>
<br/>
Format: `goto NAME_OF_TRAVEL_PLAN`<br/>
<br/>
Example: `goto Europe`

### 2. Goto Wishlist (G)
Navigates the UI to the wishlist.<br/>
<br/>
Format: `goto wishlist`<br/>
<br/>
Example: `goto wishlist`

## Add

#### 1. Adding a Travel Plan (G)
Creates a new travel plan and adds it to Wanderlust’s travel planner.
Start and end date can be optional, but they must exist as a pair. Format of date is in DD-MM-YYYY.

Format: `add -travelplan n/NAME [sd/START_DATE ed/END_DATE]`


Example: `add -travelplan n/France sd/15-09-2020 ed/30-09-2020`


#### 2. Adding an Activity (L)
Creates a new activity and adds it to the travel plan/wishlist in the current directory.  Date and time can be optional, but they must exist as a pair.
Format of date is in DD-MM-YYYY and format of time is HHMM (24h clock).

Format: `add -activity n/NAME [i/LEVEL_OF_IMPORTANCE] [l/LOCATION] [c/COST] [d/DATE_AND_TIME] [t/tags]`


Example: `add -activity n/Universal Studios Singapore i/5 l/Sentosa c/SGD88 d/16-09-2020 t/1000`


#### 3. Adding an Accommodation (L)
Creates new accommodation that contains information about the place of stay and adds it to the travel plan in the current directory.
This command can only be used within a travel plan. Use goto NAME_OF_TRAVEL_PLAN before adding accommodations.

Format: `add -accommodation n/NAME [l/LOCATION] [c/COST] [n/NIGHTS]`

### 4. Adding a Person (L)
Creates a person object that contains basic information about the user and
other travellers and adds it to the travel plan in the current directory.

Format: `add -person n/NAME [m/MOBILE_NUMBER] [p/PASSPORT_NUMBER]`


Example: `add -person n/John m/81234567 p/E1234567H`

## Delete

### 1. Deleting a Travel Plan (G)

Deletes a TravelPlan object. Users must include either the name or the index of the travel plan.

Format: `delete -travelplan n/NAME​`

Example: `delete -travelplan n/France`

### 2. Deleting an Activity (L)

Deletes an Activity object from the travel plan/wishlist in the current directory.  Users must include the name of activity or the corresponding index.

Format: `delete -activity n/NAME`

Example: `delete -activity n/Universal Studios Singapore`

### 3. Deleting an Accommodation (L)

Deletes an Accommodation object from the travel plan in the current directory. Command must include the name of the accommodation or the corresponding index.
_This command can only be used within a travel plan. Use goto NAME_OF_TRAVEL_PLAN before deleting accommodations._

Format: `delete -accommodation n/NAME​`

Example: `delete -accommodation n/Hard Rock Hotel`

### 4. Deleting a Person (L)

Deletes a Person object from the travel plan in the current directory. Command must include the name of the Person object or the corresponding index.
_This command can only be used within a travel plan. Use goto NAME_OF_TRAVEL_PLAN before deleting a person._

Format: `delete -person n/NAME`

Example: `delete -person n/John`

## Edit

#### 1. Editing a TravelPlan (G)

Edits an existing TravelPlan in the address book.

Format: `edit -travelplan INDEX n/NAME [sd/START_DATE ed/END_DATE]​`

* Edits the TravelPlan at the specified `INDEX` or name.
* Users must include the name of the travel plan or the corresponding index.
* Format of date is in DD-MM-YYYY

Examples:
* `edit -travelplan n/France sd/15-09-2020 ed/30-09-2020` Edits the start date and end date of the `France` TravelPlan.

#### 2. Editing an Activity (L)

Edits an existing Activity in the address book and updates the travel plan/wishlist in the current directory

Format: `edit -activity INDEX n/NAME [i/LEVEL_OF_IMPORTANCE] [l/LOCATION] [c/COST] [d/DATE_AND_TIME]​`

* Navigate to specified travel plan or wishlist.
* Edits the Activity at the specified `INDEX` or name.
* The index refers to the index number shown in the displayed activity list. The index **must be a positive integer** 1, 2, 3, ,,,
* Users must include the name of activity or the corresponding index.
* Format of date is in DD-MM-YYYY and format of time is HHMM (24h clock)
* At least one of the optional fields must be provided.

Examples:
*  `edit -activity n/Universal Studios Singapore i/5 l/Sentosa d/16-09-2020` Edits the location and date of the `Universal Studios Singapore` activity
*  `edit -activity 2 n/Singapore Zoo t/Animals` Edits the tag of the 2nd Activity to be `Animals` and clears all existing tags.

#### 3. Editing an Accommodation (L)

Edits existing Accommodation in the address book. This command can only be used within a travel plan.

Format: `edit -accommodation INDEX n/NAME [l/LOCATION] [c/COST] [n/NIGHTS]​`

* User navigates to specified travel plan.
* Edits the Accommodation at the specified `INDEX` or name.
* Users must include the name of Accommodation, or an index
* The index refers to the index number shown in the displayed accommodation list. The index **must be a positive integer** 1, 2, 3, ,,,
* At least one of the optional fields must be provided.

Examples:
*  `edit -accommodation n/Hard Rock Hotel c/SGD500 n/2` Edits the cost and nights of `Hard Rock Hotel` Accommodation
*  `edit -accomodation 2 c/SGD250` Edits the cost of the 2nd Accommodation to be `SGD250`

#### 4. Editing a Person (L)

Edits existing Person in the address book. This command can only be used within a travel plan.

Format: `edit -person n/NAME [m/MOBILE_NUMBER] [p/PASSPORT_NUMBER]​`

* Navigate to specified travel plan.
* Edits an existing person object’s information and updates the corresponding travel plan in the current directory
* The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.

Examples:
*  `edit -person n/John m/81234567 p/E1234567H` Edits the mobile number and passport number of `John` Person
*  `edit 2 m/87452183` Edits the mobile number of the 2nd person\

Example: `add -accommodation n/Hard Rock Hotel l/Sentosa c/SGD500 n/2`

## Show

#### 1. Viewing the Wishlist (G)

Shows the list of activities added to the wishlist, in the order they were added.

Format: `show wishlist`

Example: `show wishlist`


#### 2. Viewing Activities in a Travel Plan (G)

Shows the list of activities added to a travel plan, in the order they were added.

Format: `show NAME_OF_TRAVEL_PLAN`

Example: `show Europe Plan`

#### 3. Viewing Contacts in a Travel Plan (L)

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

#### 4. Viewing Accommodations in a Travel Plan (L)

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

#### 5. Viewing Activities in current directory (L)
Shows the list of activities added to the wishlist / travel plan of the current directory, in order they were added.

Format: `show`

Example: `show`


--------------------------------------------------------------------------------------------------------------------

## FAQ [Coming soon]

--------------------------------------------------------------------------------------------------------------------
