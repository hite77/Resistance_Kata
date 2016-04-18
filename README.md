# Resistance_Kata
1) Android Studio -- Java -- Junit for initial unit testing.
   Git Clone project, Import project, Run unit tests, by right clicking on com.hiteware.resistance_kata (tests) and selecting run.
   Run Android Simulator, or attach Android Device, and click run App button in Android studio.
   Run tests from command line, ./gradlew test to build and run tests.
2) UI -- most likely using Robolectric
3) Hamcrest matchers -- easier test notation....

Started this Kata intending to make all possible moves, and cycling through.... for 5 rows...
  create 5 paths, start at top, add a move, make two copies, and do the other two moves.... (across, and down)
  Realized that I could also achieve the same end by making a movement counter......
  0 means up, 1 means across, 2 means down.
Start at all 00000, and increment up by 1, and at 3, shift over....
00000
00001
00002
00010
.....
So create a Path with the moves currently in the counter, see if it is a better path than current solution....
Increment movement counter, and repeat same process....

Either solution, I was TDDing a Path that would store the moves, add up the resistance, and store Yes/No for made it across.

Either solution I was thinking of, would handle the same number of cases, but the counter method would only have two active Path's, and not N number of paths.


Counter could have been mocked, I chose to test edge cases by setting it.
And using that counter to insert a preset counter to test moves being made on paths.
Started running out of time, would normally have mocked the object, and used Dagger to inject for tests a mock counter.

I have this code in my github, along with HalfWayThere, released Android App to the Play Store.  It was Test Driven, with mockito, Dagger, Robolectric, custom GUI component.

Also I would like to remove magic numbers from as many places as I can....

It found an equivalent solution.  So I changed the expected to match that path.... for given two.
