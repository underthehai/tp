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
            
        - Relevant pull requests: [#158](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/158) [#265](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/266) [#270](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/270)
            
    - Implemented **navigation feature**
        - What it does: Allows users to navigate to different `travelplan` or `wishlist` using the Command Line input. The Graphics User Interface will then update to the desired directory that the user navigated to.
        - Justifications: Users will like to navigate to their desired `travelplan` or `wishlist` so that they are able to view the content in the directory on the application and plan their travel visually.
        This enhancement improved the product significantly as it provides user a convenient and fast way to go to their desired `travelplan/wishlist`, improving users' experience.
        
        - Highlights:
            - This enhancement transcends across 3 components of Wanderlust: `Ui`, `Logic`, `Model`
            - Furthermore, this enhancement required the creation of a high level component `directory` that is linked to the 4 components so that users are able to navigate between `travelplan/wishlist`.
              This enhancement required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to the architecture design of the code.
        - Relevant pull requests: [\#108](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/108), [\#100](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/100)

        
- **Minor Enhancement**:
    - Implemented **Command Line Tab Management**
        - What it does: Allows users to switch tabs between `activity`, `accommodation` and `friend` within a `travelplan` using the Command Line input. The Graphics User Interface will then update to show the desired tab that the user wished to show.
        - Relevant pull requests: [\#132](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/132) [\#265](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/265)
        
    - Implemented **feature for the Graphical User Interface**:
        - What it does: GUI shows the total cost of each `travelplan`. This is done by adding the cost of activities and accommodation in the `travelplan`.    
        - Relevant pull requests: [\#157](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/157), [\#158](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/158)

    - Implemented **time logic**
        - What it does: Prevent users from entering invalid dates that does not make sense. For example, if a user have a `travelplan` from 1 December 2020 to 31 December 2020, it will be irrational for him to add an `activity` or `accommodation`
        that is not within the range of the `travelplan`.
        - Relevant pull requests: [\#242](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/242)    
     
* **Project management**:
  * Provide direction during weekly meetings.
  * Delegate tasks weekly to team members.
  * Schedule weekly meetings.

* **Enhancements to existing features**:
  * Modified the delete feature from AB3 to fit Wanderlust  ([\#84](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/84)) [\#264](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/264)
  * Wrote additional tests for existing features to increase coverage from 66% to 70% (Pull requests [\#84](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/84), [\#99](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/99), [\#100](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/100))

* **Community**:
  * Total PRs reviewed: 94
  * PRs reviewed with non-trivial review comments: [\#32](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/32), [\#59](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/59), [\#103](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/103), [#145](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/145), [#174](ttps://github.com/AY2021S1-CS2103-T14-3/tp/pull/174), [#278](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/278), [#279](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/279) 
  * Reported bugs and suggestions for other teams in the class: [Reported 15 Bugs in PED](https://github.com/jiaweiteo/ped/issues)
  
* **Contribution to User Guide**:
  * Added documentation for the features `add`, `show` and `sort` ([\#172](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/172), [\#19](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/19)) 
  * Added documentation for Introduction, Table of Contents, Quickstart and Command Summary ([\#19](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/19))
  * Refine and finalise user guide. ([\#293](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/284))

* **Contribution to Developer Guide**:
   * Added implementation details of the `delete` feature. ([#82](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/82), [\#173](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/173))
   * Added implementation details of the `goto` feature. ([#83](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/83), [\#139](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/139))
   * Use Cases, user stories and manual testing. ([#284](https://github.com/AY2021S1-CS2103-T14-3/tp/pull/284))
   * Refine and finalise developer guide. ([\#293](ttps://github.com/AY2021S1-CS2103-T14-3/tp/pull/293))

