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