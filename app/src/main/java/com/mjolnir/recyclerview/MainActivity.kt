package com.mjolnir.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerview:RecyclerView
    lateinit var newsArrayList:ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myRecyclerview=findViewById(R.id.rvRecycleView)
        val newsImageArray= arrayOf(R.drawable.news1,R.drawable.news2,
            R.drawable.news3,R.drawable.news4,
            R.drawable.news5,R.drawable.news6,
            R.drawable.news7,R.drawable.news8,
            R.drawable.news9,R.drawable.news10,
            R.drawable.news11,R.drawable.news12
        )

        val newsTitleArray= arrayOf(
            "Jaishankar Slams Canada Over Arrest Of 3 Indians In Nijjar Case: Labels Allegations 'Vote-Bank Politics'",
            "people of pakistan-occupied kashmir will want to 'merge with india': rajnath singh",
            "Air India Reduces Free Baggage Limit For Lowest Fare Segment",
            "Prime Minister Narendra Modi offered prayers before the Ram Lalla idol during the Pran Pratishtha ceremony at the Ram Mandir in Ayodhya",
            "India Weather Updates: Heatwave to persist in THESE states; ECI adjusts polling hours in Telangana due to heat",
            "Parents should bear cost of air conditioning facility in school: Delhi HC",
            "lok sabha election: india a 'vishwabandhu', can work with us, russia for national interest: s jaishankar",
            "New Zealand introduces new rules for employer work visa holders",
            "Justin Trudeau Says 'Canada Is A Rule-Of-Law Country' After Arrest Of 3 Indians, MEA Hits Back",
            "Bengal Governor CV Ananda Bose asks Raj Bhavan staff to ignore communication from Kolkata Police regarding molestation",
            "Dharamsala crowd goes on 'mute mode' as CSK hero MS Dhoni falls for a golden duck",
            "Rahul Gandhi Dares PM Modi To Remove 50% Cap On Reservations, Says 'Congress Will If Elected'")


        val newsContent= arrayOf(
            getString(R.string.news),getString(R.string.news),
            getString(R.string.news),getString(R.string.news),
            getString(R.string.news),getString(R.string.news),
            getString(R.string.news),getString(R.string.news),
            getString(R.string.news),getString(R.string.news),
            getString(R.string.news),getString(R.string.news)
            )

        myRecyclerview.layoutManager=LinearLayoutManager(this)
        newsArrayList= arrayListOf<News>()

        for(i in newsImageArray.indices){
            val news=News(newsTitleArray[i],newsImageArray[i],newsContent[i])
            newsArrayList.add(news)
        }
        var myAdapter=MyAdapter(newsArrayList,this)
        myRecyclerview.adapter=myAdapter
        myAdapter.setOnItemClickOnListener(object:MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                intent=Intent(this@MainActivity,NewsDetailsActivity::class.java)
                intent.putExtra("newsImgId",newsArrayList[position].newsImage)
                intent.putExtra("newsHeading",newsArrayList[position].newsHeading)
                intent.putExtra("newsDetails",newsArrayList[position].newsContent)
                startActivity(intent)

            }

        })
    }
}