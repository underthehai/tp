---
layout: page
title: Teo Jia Wei's Project Portfolio Page
---

## Project: Wanderlust

WanderLust is a desktop travel planner application. It allows users to plan their trips in a structured and efficient manner.
The user interacts with it using a CLI, and it has a GUI created with JavaFX.
It is written in Java, and has about 16 kLOC.

## Summary of Contributions

- Code contributed: [RepoSense](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=jiaweiteo)

- **Major Enhancement**: 
    - Implemented **sort feature**
        - What it does: Allow users to sort `activity/ accommodation/ friend` based on their desired view. (Etc. Sort activity by cost)
        - Justifications: As our target users are travel goers, they would likely want to view a sorted list of activities/ accommodation/ friend that 
        is neat and easy to analyse. This will allow them to track their travel plans better as the list will not be messy. For example, a user may want to sort its activities
        by date so that he/she will know the list of events that will be happening in chronological order.
        This enhancement improved the product significantly as users will now be able to sort their items and provide a convenient way for users to view their desired order of items.
    
        - Highlights: 
            - This enhancement transcends across all 4 components of Wanderlust: `Ui`, `Logic`, `Model` and `Storage`.
            - This enhancement is highly coupled with the edit/delete features as these two features make use of the index of a `travelplanobject`.
            - For example, when a user sort his activities, the activity list in the `Model` will be updated. In order to use the index reflected in the 
            `Ui` on the new activity, the corresponding activity list in `Storage` must be updated and synced with the sorted ordered list reflected in the `Ui`.
            
        - Relevant pull requests: [\#158]()
        
    - Modified **delete feature** from AB3 to fit Wanderlust
        - What it does: Allows user to delete a `travelplan` or a `travelplanobject` in the application. (Etc. Delete an activity)
        - Justifications: As our target users are travel goers, they would likely want a delete feature to remove any unwanted `travelplan` or `travelplanobject` that
        they have added. For example, a user may have added in an activity, but realised he does not want to do this activity, and hence will require the delete feature to remove the particular activity.
        
        -Highlights:
            - This enhancement involves full-stack development in all 4 components of Wanderlust: `Ui`, `Logic`, `Model` and `Storage`.
            - This enhancement requires a high level `deletecommand`, which is extended from 4 subclasses `DeleteActivityCommand`, `DeleteAccommodationCommand`, `DeleteFriendCommand`, `DeleteTravelplanCommand`.
            This is to ensure abstraction.
        
        - Relevant pull requests: [\#84]()
            
    - Implemented **navigation feature**
        - What it does: Allows users to navigate to different `travelplan` or `wishlist` using the Command Line input. The Graphics User Interface will then update to the desired directory that the user navigated to.
        - Justifications: Users will like to navigate to their desired `travelplan` or `wishlist` so that they are able to view the content in the directory on the application and plan their travel visually.
        This enhancement improved the product significantly as it provides user a convenient and fast way to go to their desired `travelplan/wishlist`, improving users' experience.
        
        - Highlights:
            - This enhancement transcends across 3 components of Wanderlust: `Ui`, `Logic`, `Model`
            - Furthermore, this enhancement required the creation of a high level component `directory` that is linked to the 4 components so that users are able to navigate between `travelplan/wishlist`.
            This enhancement required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to architecture design of the code.
            - This enhancement was contributed together as a team, with @lyeyixian and @jeannetoh building on the `Model` and `Ui` aspect respectively.
        - Relevant pull requests: [\#108](), [\#100]()
        
    - Implemented **time logic**
        - What it does: Prevent users from entering invalid dates that does not make sense. For example, if a user have a `travelplan` from 1 December 2020 to 31 December 2020, it will be irrational for him to add an `activity` or `accommodation`
        that is not within the range of the `travelplan`.
        - Justifications: I decided to implement this logic to ensure the coherence of the application, so that users can have a proper `travelplan` depicting accurate dates and prevent any irrational timeline from happening in the `travelplan`.
        This is aimed at our target users, who are travelgoers planning for trips and hence, a comprehensive and well-structured time logic is needed in the applicaiton.
        
        - Relevant pull requests: [\#242]()
        
- **Minor Enhancement**:
    - Implemented **Command Line Tab Management**
        - What it does: Allows users to switch tabs between `activity`, `accommodation` and `friend` within a `travelplan` using the Command Line input. The Graphics User Interface will then update to show the desired tab that the user wished to show.
        - Justifications: Users will like to view their desired `travelplanobject` on the application so that they can plan any `activity`/`accommodation`/`friend` or make any changes to it.
        While a GUI would make sense for tedious actions like editing, the command line is arguably faster for simpler actions like switching tabs. Furthermore, our target users are tech-savvy travellers who are used to command line window. Hence, I decided to implement a command line version for tab management to optimize for these users, which will help improve their user experience.
        
        - Relevant pull requests: [\#132]()
        
    - Implemented **feature for the Graphical User Interface**:
        - What it does: GUI shows the total cost of each `travelplan`. This is done by adding the cost of activities and accommodation in the `travelplan`.
        - Justifications: Users with a budget for their `travelplan` will be able to keep track of their total cost incurred thus far easily and hence, optimising users' experience.
    
        - Relevant pull requests: [\#157](), [\#158]()
        
* **Project management**:
  * Provide direction during weekly meetings.
  * Delegate tasks weekly to team members.
  * Schedule weekly meetings.
  * Create the template for the implementation aspect of developer guide.

* **Enhancements to existing features**:
  * Updated the delete feature ([\#84]())
  * Wrote additional tests for existing features to increase coverage from 66% to 70% (Pull requests [\#84](), [\#99](), [\#100]())

* **Documentation**:
  * User Guide:
    * Added documentation for the features `add`, `show` and `sort` ([\#172](), [\#19]()) 
    * Added documentation for Introduction, Table of Contents, Quickstart and Command Summary ([\#19]())
  * Developer Guide:
    * Added implementation details of the `delete` feature. [#82]() ([\#173]())
    * Added implementation details of the `goto` feature. [#83]() ([\#139]())

* **Community**:
  * Total PRs reviewed: 60 
  * PRs reviewed with non-trivial review comments: [\#32](), [\#59](), [\#103](), [#145](), [#174]() 
  * Contributed to forum discussions: [1](), [2](), [3](), [4]()
  * Reported bugs and suggestions for other teams in the class: [Reported 15 Bugs in PED](https://github.com/jiaweiteo/ped/issues)
