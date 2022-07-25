# aws-assessment-tasks
Tasks I have solved during the assessment. 105 mins are provided for two tasks, I had 5 mins left when I finished.

Note: My solutions aren't the best, but I hope it will help you to train :)

1. findRestaurants

Input:

allLocations - a list of pairs of integers ( x and y coordinates ).
   
numRestaurants - number of returned restaurants.

Output:

Return a list of coordinates of the nearest to [0,0] restaurants.
The distance is calculated as sqrt(x^2+y^2).
The initial location is of a customer is [0,0]


Example:

allLocations = [[1,2],[3,4],[1,-1]]

numRestaurants = 2

Output:

[[1,-1],[1,2]]

Solution: 

Use hashmap to memorize the indexes of the calculated distances. 
Sort the map by value and get first numRestaurants keys (indexes) from the map to get initial coordinates from allLocations array

2. predictDays

Input:

day - a list of days
k - number of consideration days

Output:

Return the array of ideal days in ascending order. 
The ith element of the array represents the data for the day i + 1.
It is guaranteed that there's at least one ideal day.

Example:

day= [3,2,2,2,3,4]

k=2

Output:

[3,4]

day=[1,0,1,0,1]

k=1

Output:

[2,4]

Explanation: The day is ideal if the amount of rainfall has to be non-increasing for the prior k days and non-decreasing for the following k days.

Solution:

Iterate over the day array within left and right bounds according to k. 
Check that both left and right days ( prior and after ) are good. If so, add the day index+1 ( the days start from 1, not from 0 ) and drop the left and right flags.
The day checking: we check the current day to the previous/next for non-increasing/non-decreasing behaviour.

3. numberOfItems (this is a testing task, just for training before task 1 and task 2 above)

Input:

s - string with container walls (|) and items (*)

startIndices - list of starting indices

endIndices - list of ending indices

Output:

[2,3]

Example:

s="|**|*|*"

startIndices = [1,1]

endIndices = [5,6]

Output:

[2,3]

Explanation:

First bound is 1-5, there are two items within the container and three items within two containers in 1-6 bounds.


