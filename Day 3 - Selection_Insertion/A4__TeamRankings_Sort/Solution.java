class Solution {
	public Team[] sort(Team[] teams) {
		// your code goes here

		for(int i = 0; i < teams.length; i++) {

			int indeoOfMinimum = i;

			// iterate through remaining teams, find the one ranked least
			for(int j = i + 1; j < teams.length; j++) {

				if(teams[j].compareTo(teams[indeoOfMinimum]) > 0) {
					indeoOfMinimum = j;
				}

			}

			Team temp = teams[i];
			teams[i] = teams[indeoOfMinimum];
			teams[indeoOfMinimum] = temp;
		}
		return teams;
	}
}

class Team implements Comparable<Team> {
	String teamName;
	int noOfWins;
	int noOfLosses;
	int noOfDraws;
	Team(String name, int wins, int losses, int draws){
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}

	/**
	 * compareTo()
	 * check wins, then losses, then draws.
	 */
	public int compareTo(Team teamToCompare) {

		if (this.noOfWins > teamToCompare.noOfWins) {
			return 1;
		}
		if (this.noOfWins < teamToCompare.noOfWins) {
			return -1;
		}
		// if code above doesn't execcuted, says noOfWins are equal.


		if (this.noOfLosses > teamToCompare.noOfLosses) {
			return -1;                                     // more losses
		}
		if (this.noOfLosses < teamToCompare.noOfLosses) {
			return 1;
		}
		// if code above doesn't execcuted, says noOfWins are equal as well losses.


		if (this.noOfDraws > teamToCompare.noOfDraws) {
			// team with more noOfDraws is good.
			return 1;
		}

		if (this.noOfDraws < teamToCompare.noOfDraws) {
			return -1;
		}
	   return 0;
	}


	public String toString(){
		//retrun all the attributes as a string but appending with ", "
        return  "{" + teamName + "," + noOfWins + "," + noOfLosses + "," + noOfDraws + "}";
    }
}