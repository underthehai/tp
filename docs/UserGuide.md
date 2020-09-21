---
layout: page
title: User Guide
---
#Wanderlust v1.2 User Guide

## Introduction

WanderLust helps tech-savvy travellers to plan their trips in a structured and efficient manner by providing them with a holistic travel planner. 
It is optimized for CLI users so that destinations and details can be added faster by typing in commands.

* Table of Contents
{:toc}

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
`show LIST_OF_OBJECTS` | `LIST_OF_OBJECTS` wishlist / nameOfTravelPlan / contacts / accomdation / <empty> | Show the specific list of objects given. If <listOfObjects> is empty, WanderLust will show the current travel plan the user is at.

--------------------------------------------------------------------------------------------------------------------
##Tags

The table below shows the type of tag each different object can be assigned to. 
Do note that tags are optional when creating the object.

####Activity Tag
Name of Tag | Description
------------ | -------------
`l/LOCATION` | Location/ Address of the activity.
`i/LEVEL_OF_IMPORTANCE` | The priority assigned to the activity. 
`c/cost` | Cost of the activity, if any.
`d/DATE_AND_TIME` | Date and Time intended to do the activity. Format of date is in DD-MM-YYYY and format of time is HHMM (24h clock).


####Accommodation Tag
Name of Tag | Description
------------ | -------------
`l/LOCATION` | Location/ Address of the accommodation.
`n/NIGHTS` | Number of nights to be spent in the accommodation.
`c/cost` | Cost of the accommodation, if any.

####Person Tag
Name of Tag | Description
------------ | -------------
`m/MOBILE_NUMBER` | Mobile number of the person cell phone
`p/PASSPORT_NUMBER` | Passport number of the person passport

####Travel Plan Tag
Name of Tag | Description
------------ | -------------
`sd/START_DATE` | Start date of travel in the format of DD-MM-YYYY
`ed/END_DATE | End date of travel in the format of DD-MM-YYYY

####Wishlist Tag
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

## Add

###Adding a Travel Plan (G)
Creates a new travel plan and adds it to Wanderlust’s travel planner. 
Start and end date can be optional, but they must exist as a pair. Format of date is in DD-MM-YYYY.

Format: `add -travelplan n/NAME [sd/START_DATE ed/END_DATE]`


Example: `add -travelplan n/France sd/15-09-2020 ed/30-09-2020`


###Adding an Activity (L)
Creates a new activity and adds it to the travel plan/wishlist in the current directory.  Date and time can be optional, but they must exist as a pair. 
Format of date is in DD-MM-YYYY and format of time is HHMM (24h clock).

Format: `add -activity n/NAME [i/LEVEL_OF_IMPORTANCE] [l/LOCATION] [c/COST] [d/DATE_AND_TIME]`


Example: `add -activity n/Universal Studios Singapore i/5 l/Sentosa c/SGD88 d/16-09-2020 t/1000`


###Adding an Accommodation (L)
Creates new accommodation that contains information about the place of stay and adds it to the travel plan in the current directory.
This command can only be used within a travel plan. Use goto NAME_OF_TRAVEL_PLAN before adding accommodations.

Format: `add -accommodation n/NAME [l/LOCATION] [c/COST] [n/NIGHTS]`


Example: `add -accommodation n/Hard Rock Hotel l/Sentosa c/SGD500 n/2`

###Adding a Person (L)
Creates a person object that contains basic information about the user and 
other travellers and adds it to the travel plan in the current directory.

Format: `add -person n/NAME [m/MOBILE_NUMBER] [p/PASSPORT_NUMBER]`


Example: `add -person n/John m/81234567 p/E1234567H`

--------------------------------------------------------------------------------------------------------------------

## FAQ [Coming soon]

--------------------------------------------------------------------------------------------------------------------
