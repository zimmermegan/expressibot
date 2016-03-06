package twittersentiment;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import edu.smu.tspell.wordnet.*;


public class What2Think {
	
	
	public static String tweetFeels(String tweet)
	{
		//init of wordnet
		System.setProperty("wordnet.database.dir", "C:/Program Files (x86)/WordNet/2.1/dict/");
		WordNetDatabase database = WordNetDatabase.getFileInstance();
		
		String emotion="";
		//probability dec
		double probHappy=0.0;
		double probMad=0.0;
		double probEmbarrased=0.0;
		double probWorried=0.0;
		double probExcited =0.0;
		double probNeutral = 0.0;
		double probConfused =0.0;
		double sheMadtho = 0.0;
		double probSad =0;
		//counters
		int happyCount = 0;
		int madCount = 0;
		int embarrasedCount =0;
		int worriedCount = 0;
		int excitedCount =0;
		int nuetralCount =0;
		int confusedCount = 0;
		int madthoCount = 0;
		int sadCount=0;
		
		//tag dec
		ArrayList<String> happy = new ArrayList(Arrays.asList("good","obama","smile","adore","affable","aggreeable","amiable","amusing","animated","appealing","beaming","beatific","beautiful","bliss","blissful","blithe","buoyant","carefree","charming","cheerful","cheeriness","cheery","chipper","chirpy","content","contented","delight","delighted","delightful","diverting","favorable","fine","friendly","fulfilled","fun","funny","grateful","gratified","gratify","gratifying","great","grinning","happiness","happy","heartening","heartwarming","heavenly","hilarious","hopeful","paradise","perkiness","perky","pleasant","pleased","pleasure","precious"));
		
		ArrayList<String> mad = new ArrayList<String>(Arrays.asList("ass","asshole","bitch","bastard","bollocks","cunt","assclown","upset","trump","fuck","faceface","fuckass","assfuck","shit","dogshit","bearshit","ass","pissed","bumblefuck","cock","crap","cheesedick","chode","queef","dick","cum","cumdumpster","dickwad","dickhead","jabronie","dingus","whore","feminazi","fag","whore","fuckface","fucktard","fuckhead","fuckhole","needledick","motherfucker","pussy","puta","weaboo","queer","annoyed","irritated","offended","hate"));
		
		ArrayList<String> sad = new ArrayList<String>(Arrays.asList("sad","unhappy","sorrowful","depressed","dejected","downcast","miserable","despondent","desparing","disconsolate","desolate","wretched","glum","gloomy","doleful","dismal","melancholy","mournful","woebegone","forlon","crestfallen","heartbroken","inconsolable","cry","crying","inadequate","sadness","depression","bitter","morbid","death","dying","pessimistic","bleak","distress","restlessness","anxiety","grim","somber","sullen","mournful","mourning","mourn","RIP","R.I.P.","miserable","dull","joyless","hopeless","horrible","sinister","ominous","foreboding","atrocious","depressive","funereal","dead","funeral"));
		
		ArrayList<String> worried = new ArrayList<String>(Arrays.asList("anxious", "worried", "troubled", "peturbed", "bothered", "concerned", "distressed", "tense", "overwrought", "fearful", "afraid", "scared", "uptight", "tormented", "frightened", "disturbed", "distracted", "fretful", "nervous", "uneasy","alarmed","concerned","doubtful","frantic"));
		
		ArrayList<String> embarrased = new ArrayList<String>(Arrays.asList("embarrassed", "embarrassing","ashamed", "diconcerted", "flustered", "abashed", "blushing" , "blushie", "rattled", "fazed", "humbled", "awkward", "bashful", "shy", "blushful", "coy", "flushed", "glowing", "crimson", "rosy", "blush"));
		
		ArrayList<String> excited = new ArrayList<String>(Arrays.asList("delighted","eager","enthusiastic","hysterical","passionate","thrilled","animated","aroused","awakened","charged","discomposed","inflamed","piqued","roused","stimulated","stirred","wired","fired up","high","hyperactive","in a tizzy","juiced up","jumpy","keyed up","on edge","energetic","ampedup","ciced","crunk","hype","jacked","siked","stoked","pumped","awesome","sweet","excited","excite","intoxication","omg","yas","cool","!!!","slay"));
		
		ArrayList<String> nuetral = new ArrayList<String>(Arrays.asList("calm","quiet","apathy","calmness","order","okay","bored","boring","dull","dullness","inactivity","stillness","peace","eh","meh","idleness","idle","nuetral","switzerland","undecided"));
		
		ArrayList<String> confused = new ArrayList<String>(Arrays.asList("???","what","huh","fog","perturb","puzzle","trouble","unsettle","rattle","stump","mess up","stir up","throw off","cloud","baffle","befuddle","confound","daze","perplex","disorient","distract","muddle","mislead","misinform","discomfort","faze","wtf?","bewild","at a loss","taken aback","thrown off","flummoxed","nonplussed","discombobulated","not with it","chaotic","jumbled","weird","disarranged","confused","uhh"));
		
		ArrayList<String> shemad = new ArrayList<String>(Arrays.asList("serious","seriously","honestly","sober","uhmm","uhh","...","cold","deadpan","set","uninterested","distant","turned off","turnoff","withdrawn","apathetic","detached","uninvolved","unconcerned","disinterested","indifferent","don't care","unresponsive","apathetic","listless","stiff","incurious","whatever","bitch please","forreal","for real","no joke","stupid","not funny","sarcasm"));

		
		
		ArrayList<String> sentence=new ArrayList<String>(); 
		StringTokenizer st = new StringTokenizer(tweet," ");
		
		while(st.hasMoreElements())
			{
			String thing = st.nextToken();
			Synset[] synsets = database.getSynsets(thing);
			sentence.add(st.nextToken());
			
			int lenthing = 1;
			if(synsets.length > 0)

			{
				lenthing = synsets.length;

				for(int i =0; i< synsets.length; i++)
					{
					String[] words = synsets[i].getWordForms();
					for (int j = 0;j<words.length;j++)
						{
							if (happy.contains(words[j]))
							{
								happyCount++;
							}
							else if (sad.contains(words[j]))
							{
								sadCount++;
							}
							else if (mad.contains(words[j]))
							{
								madCount++;
							}
							else if(embarrased.contains(words[j]))
							{
								embarrasedCount++;
							}
							else if(worried.contains(words[j]))
							{
								worriedCount++;
							}							
							else if(excited.contains(words[j]))
							{
								excitedCount++;
							}
							else if(nuetral.contains(words[j]))
							{
								nuetralCount++;
							}
							
							else if(confused.contains(words[j]))
							{
								confusedCount++;
							}
							else if(shemad.contains(words[j]))
							{
								madthoCount++;
							}
						}
					}
				}
			probHappy = happyCount/lenthing;
			probSad = sadCount/lenthing;
			probMad = madCount/lenthing;
			probEmbarrased = embarrasedCount/lenthing;
			probNeutral = nuetralCount/lenthing;
			probExcited = excitedCount/lenthing;
			probWorried = worriedCount/lenthing;
			probConfused = confusedCount/lenthing;
			sheMadtho = madthoCount/lenthing;
			double[] probList = {probHappy,probSad,probEmbarrased,probMad,probNeutral,probExcited,probWorried,probWorried,probConfused,sheMadtho};
			double max = 0.0;
			String winner="";
			for (int i=0; i<probList.length; i++)
				{
				if (probList[i]>max)
					{
					max = probList[i];
					if(i==1)
						{
							winner="happy";
						}
					if(i==2)
						{
						winner="sad";
						}
					if(i==3)
						{
						winner="embarrased";
						}
					if(i==4)
						{
						winner="mad";
						}
					if(i==5)
						{
						winner="neutral";
						}
					if(i==6)
						{
						winner="excited";
						}
					if(i==7)
						{
						winner = "worried";
						}
					if(i==8)
						{
						winner="confused";
						}
					if(i==9)
						{
						winner="serious";
						}
					}
				emotion = winner;
				}
			}
			
	
		return emotion;
	}
    public static void main(String[] args) {
        String topic = "umbcfeelingsbot";
        ArrayList<String> tweets = TweetManager.getTweets(topic);
        NLP.init();
        for(String tweet : tweets) {
    		int sentiment = NLP.findSentiment(tweet);

        	String emotion = tweetFeels(tweet);
        	if (emotion=="" ||sentiment<=1 )
        	{
        		if (sentiment==1)
        		{
        			emotion = "sad";
        		}
        		if (sentiment==2)
        		{
        			emotion = "neutral";
        		}
        		if(sentiment==3)
        		{
        			emotion = "happy";
        		}
        	}
            System.out.println(tweet + " : " + sentiment+" " +emotion);
        }
    }
}