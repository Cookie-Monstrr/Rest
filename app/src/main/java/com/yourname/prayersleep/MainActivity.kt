class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Initialize views
        setupViews()
        
        // Display current time
        updateCurrentTime()
        
        // Show sample prayer times (you'll replace this with real calculation later)
        displaySamplePrayerTimes()
    }
    
    private fun setupViews() {
        // Find views by ID (we'll create these in the layout file)
        val currentTimeText = findViewById<TextView>(R.id.currentTimeText)
        val nextPrayerText = findViewById<TextView>(R.id.nextPrayerText)
        
        // Set welcome message
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        welcomeText.text = "Prayer & Sleep Schedule"
    }
    
    private fun updateCurrentTime() {
        val currentTimeText = findViewById<TextView>(R.id.currentTimeText)
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = timeFormat.format(Date())
        currentTimeText.text = "Current Time: $currentTime"
    }
    
    private fun displaySamplePrayerTimes() {
        val nextPrayerText = findViewById<TextView>(R.id.nextPrayerText)
        
        // Sample prayer times (you'll calculate real ones later)
        val samplePrayerTimes = mapOf(
            "Fajr" to "05:15",
            "Dhuhr" to "12:30",
            "Asr" to "15:45",
            "Maghrib" to "18:20",
            "Isha" to "19:50"
        )
        
        // Find next prayer (simplified logic for now)
        val nextPrayer = findNextPrayer(samplePrayerTimes)
        nextPrayerText.text = "Next Prayer: $nextPrayer"
    }
    
    private fun findNextPrayer(prayerTimes: Map<String, String>): String {
        // Simple logic to find next prayer
        // You'll improve this with proper time calculation later
        val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        
        return when {
            currentHour < 5 -> "Fajr at ${prayerTimes["Fajr"]}"
            currentHour < 12 -> "Dhuhr at ${prayerTimes["Dhuhr"]}"
            currentHour < 15 -> "Asr at ${prayerTimes["Asr"]}"
            currentHour < 18 -> "Maghrib at ${prayerTimes["Maghrib"]}"
            currentHour < 19 -> "Isha at ${prayerTimes["Isha"]}"
            else -> "Fajr at ${prayerTimes["Fajr"]} (tomorrow)"
        }
    }
}
