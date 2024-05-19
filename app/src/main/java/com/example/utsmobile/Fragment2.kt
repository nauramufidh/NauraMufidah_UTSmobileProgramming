package com.example.utsmobile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment(R.layout.fragment2) {
    private lateinit var newsListView: ListView
    private lateinit var newsAdapter: Adapterfragment2
    private lateinit var newsList: List<NewsData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment2, container, false)

        newsListView = view.findViewById(R.id.newsListView)

        // Dummy data
        newsList = listOf(
            NewsData(R.drawable.ic_launcher_foreground, "Jokowi Akan Sambut Delegasi WWF Ke-10 Saat Gala Dinner di GWK", "Kepala negara dan para delegasi dalam rangkaian World Water Forum ke-10 akan dijamu sambutan makan malam di Taman Budaya Garuda Wisnu Kencana.", ""),
            NewsData(R.drawable.ic_launcher_foreground, "Oleksandr Usyk Sah Jadi Raja Tinju Dua Kelas", "Oleksandr Usyk menang atas Tyson Fury. Kemenangan itu menjadikan Usyk sah jadi raja tinju dua kelas, yakni kelas berat dan cruiser!.",""),
            NewsData(R.drawable.ic_launcher_foreground, "Narasi 'End Bin Wassalam' Antara PDIP dengan Jokowi", "Polemik tak diundangnya Presiden Joko Widodo (Jokowi) ke Rakernas PDIP terus memanas.", ""),
            NewsData(R.drawable.ic_launcher_foreground, "Perjalanan Kasus Korupsi Tol MBZ hingga Mutu Beton Tuai Sorotan", "Kasus korupsi Jalan Layang Sheikh Mohammed Bin Zayed atau dikenal dengan Tol MBZ saat ini tengah berjalan di persidangan.", ""),
            NewsData(R.drawable.ic_launcher_foreground, "Leverkusen Tak Terkalahkan, Xabi Alonso Samai Para Pelatih Hebat Ini", "Xabi Alonso berhasil membawa Bayer Leverkusen juara Bundesliga tanpa terkalahkan. Alonso menyamai catatan para pelatih hebat di Eropa.",""),
            NewsData(R.drawable.ic_launcher_foreground, "Kapal Tanker Milik Yunani Dihantam Rudal Houthi di Yaman", "Komando Pusat Amerika Serikat mengatakan rudal yang ditembakkan oleh pemberontak menghantam sebuah kapal tanker minyak Yunani.", ""),
            NewsData(R.drawable.ic_launcher_foreground, "Mensos Risma Tanggapi Keluhan Warga Sumba Timur soal Air Bersih", "Menteri Sosial Tri Rismaharini mengunjungi kediaman Niwa Lepir di Desa Pambotanjara, Kecamatan Kota Waingapu, Kabupaten Sumba Timur, Provinsi Nusa Tenggara Timur.", ""),
            NewsData(R.drawable.ic_launcher_foreground, "Polisi Tangkap 11 Remaja Hendak Tawuran di Cibinong, Sita 4 Celurit", "Sebanyak 11 remaja diduga hendak tawuran diamankan polisi di Cibinong, Kabupaten Bogor. Empat senjata tajam jenis celurit dan 7 unit motor disita.",""),
            NewsData(R.drawable.ic_launcher_foreground, "Awas Macet! Ada Pemeliharaan Jalan di Tol Jagorawi hingga 26 Mei", "Jasa Marga melakukan pemeliharaan di sejumlah titik jalan Tol Jagorawi arah Jakarta maupun arah Bogor. Pengerjaan akan berlangsung selama sepekan ke depan.",""),
            NewsData(R.drawable.ic_launcher_foreground, "11 Nelayan Hilang Usai Kapal Ikan Tenggelam di Afrika Selatan", "Layanan penyelamatan Afrika Selatan mengatakan kapal pukat tenggelam di Atlantik Selatan. Sebanyak 11 nelayan dinyatakan hilang.","")
        )

        newsAdapter = Adapterfragment2(requireContext(), newsList)
        newsListView.adapter = newsAdapter

        // Set click listener for ListView items
        newsListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedItem = newsList[position]
            val intent = Intent(activity, NewsDetailActivity::class.java).apply {
                putExtra("imageResId", selectedItem.imageResId)
                putExtra("title", selectedItem.title)
                putExtra("description", selectedItem.shortDescription) // Ensure this matches the correct field name
                putExtra("fullDescription", selectedItem.fullDescription) // Ensure fullDescription is included
            }
            startActivity(intent)
        }

        return view
    }
}
