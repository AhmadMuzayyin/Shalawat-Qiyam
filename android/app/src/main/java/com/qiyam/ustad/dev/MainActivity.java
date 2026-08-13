package com.qiyam.ustad.dev;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = findViewById(R.id.mainContentLayout);

        // Load Amiri-Bold font
        Typeface amiriBold;
        try {
            amiriBold = Typeface.createFromAsset(getAssets(), "public/fonts/Amiri-Bold.ttf");
        } catch (Exception e) {
            try {
                amiriBold = Typeface.createFromAsset(getAssets(), "fonts/Amiri-Bold.ttf");
            } catch (Exception e2) {
                amiriBold = Typeface.DEFAULT_BOLD;
            }
        }

        // 1. Bismillah & Title
        addBismillah(container, "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ", amiriBold);
        addTitle(container, "مَوْلِدُ الدِّيْبَعِى", amiriBold);

        // 2. Qasidah Diba (12 rows)
        String[][] dibaData = {
            {"يَارَبِّ صَـــــلِّ عَليٰ مُحَمَّــــــــــدْ", "يَارَبِّ صَلِّ عَلَيْـــــــــهِ وَسَــــــلِّمْ"},
            {"يَارَبِّ بَلِّغْـــــــــهُ الْوَسِيْــــــــــــلَةْ", "يَارَبِّ خُصَّـــــهٗ بِالْفَضِيْــــــــــــلَةْ"},
            {"يَارَبِّ وَارْضَ عَنِ الصَّحَـــــــابَةْ", "يَارَبِّ وَارْضَ عَنِ السُّـــــــــلاَلَةْ"},
            {"يَارَبِّ وَارْضَ عَنِ الْمَشَــــــــايِخْ", "يَارَبِّ فَارْحَـــــــمْ وَالِدِيْنَــــــــــــا"},
            {"يَارَبِّ وَارْحَمْـــــــــنَا جَمِيْـــــــــــعًا", "يَارَبِّ وَارْحَـــــــــــمْ كُلَّ مُسْــــلِمْ"},
            {"يَارَبِّ وَاغْفِـــــــــرْ لِكُلِّ مُــــذْنِبْ", "يَارَبِّ لَاتَقْطَـــــــــعْ رَجَـــــــــــانَا"},
            {"يَارَبِّ يَاسَامِــــــــــعْ دُعَــــــــــانَا", "يَارَبِّ بَلِّغْـــــــــــــــــــــــنَا نَزُوْرُهْ"},
            {"يَارَبِّ تَغْشَــــــــــــــــــــانَا بِنُوْرِهْ", "يَارَبِّ حِفْـــــــــــــظَانَكْ وَاَمَانَكْ"},
            {"يَارَبِّ وَاسْـــــــــكِنَّا جِـــــــنَانَكْ", "يَارَبِّ أَجِــرْنَا مِنْ عَــــــــــذَابِكْ"},
            {"يَارَبِّ وَارْزُقْنَـــــــــا الشَّــــــهَادَةْ", "يَارَبِّ حِطْـــــــنَا بِالسَّعَـــــــــادَةْ"},
            {"يَارَبِّ وَاصْــــلِحْ كُلَّ مُصْـــــــلِحْ", "يَارَبِّ وَاكْــــــــــفِ كُلَّ مُـــؤْذِيْ"},
            {"يَارَبِّ نَخْــــــــتِمْ بِالْمُشَـــــــــــفَّعْ", "يَارَبِّ صَلِّ عَلَيْـــــــــهِ وَسَــــــلِّمْ"}
        };

        for (String[] row : dibaData) {
            addQasidahRow(container, row[0], row[1], amiriBold);
        }

        addDivider(container, amiriBold);

        // 3. Paragraph 1: Laqad Ja'akum
        String laqadText = "لَقَدْ جَاۤءَكُمْ رَسُوْلٌ مِّنْ اَنْفُسِكُمْ عَزِيْزٌ عَلَيْهِ مَا عَنِتُّمْ حَرِيْصٌ عَلَيْكُمْ بِالْمُؤْمِنِيْنَ رَءُوْفٌ رَّحِيْمٌ • فَاِنْ تَوَلَّوْا فَقُلْ حَسْبِيَ اللَّهُ لَا اِلٰهَ إِلَّا هُوَ ۖ عَلَيْهِ تَوَكَّلْتُ ۖ وَهُوَ رَبُّ الْعَرْشِ الْعَظِيْمِ •";
        addParagraph(container, laqadText, amiriBold);

        addDivider(container, amiriBold);

        // 4. Paragraph 2: Fahtazzal 'Arsyu
        String fahtazzalText = "فَاهْتَزَّ الْعَرْشُ طَرَبًا وَاسْتِبْشَارًا • وَازْدَادَ الْكُرْسِيُّ هَيْبَةً وَوَقَارًا • وَامْتَلَأَتِ السَّمٰوَاتُ أَنْوَارًا • وَضَجَّتِ الْمَلَآئِكَةُ تَهْلِيْلًا وَتَمْجِيْدًا وَاسْتِغْفَارًا • سُبْحَانَ الله وَالْحَمْدُ ِللهِ وَلَآإِلٰهَ إِلاَّ اللهُ وَاللهُ أَكْبَرْ ٣× • وَلَمْ تَزَلْ أُمُّهٗ تَرٰى أَنْوَاعًا مِنْ فَخْرِهِ وَفَضْلِهِ • إِلىٰ نِهَايَةِ تَمَامِ حَمْلِهِ • فَلَمَّا اشْتَدَّ بِهَا الطَّلْقُ • بِـإِذْنِ رَبِّ الْخَلْقِ • وَضَعَتِ الْحَبِيْبَ صَلَّى اللهُ عَلَيْهِ وَسَلَّمَ • سَاجِدًا شَاكِـرًا حَامِدًا كَأَنَّهُ الْبَدْرُ فِيْ تَمَامِهِ";
        addParagraph(container, fahtazzalText, amiriBold);

        addDivider(container, amiriBold);

        // 5. Title 2: Mahallul Qiyam
        addTitle(container, "مَحَلُّ اْلقِيَامِ", amiriBold);

        // 6. Qasidah Qiyam (39 rows)
        String[][] qiyamData = {
            {"يَانَبِـــــــــــــــــــــى سَلَامٌ عَلَيْكَ", "يَارَسُوْلَ سَـــــــــلَامٌ عَلَيْــــــــكَ"},
            {"يَاحَبِيْبْ سٰـــــــــلَامٌ عَلَيْـــــــكَ", "صَـــــــــلَوٰاتُ اللهِ عَلَيْـــــــــــكَ"},
            {"اَشْرَقَ الْبَــــدْرُ عَـلَيْــــــــــــــــــنَا", "فَاخْتَــــفَــــتْ مِنْـــــــــــهُ الْبُــــدُوْرُ"},
            {"مِثْلَ حُسْنِــــــــكْ مَا رَاَيْــــــــنَا", "قَــــطُّ يَاوَجْــــهَ السُّـــــــــــــرُوْرِ"},
            {"اَنْتَ شَمْـــــــــسٌ اَنْتَ بَــــــــدْرٌ", "اَنْتَ نُـــــــــــوْرٌ فَــــــوْقَ نُــــوْرٍ"},
            {"اَنْتَ اِكْسِـــــــيْرٌ وَغَــالِــــــــــــي", "اَنْتَ مِصْبَـــــــــاحُ الصُّـــــــدُوْرِ"},
            {"يَاحَبِيْبِـــــــــيْ يَامُـــــــــــــــحَمَّدُ", "يَاعَرُوْسَ الْخَـــــــــافِقَــــــــــــيْنِ"},
            {"يَامُؤَيَّدْ يَامُمَجَّــــــــــــــــــــــــــدُ", "يَاإِمَامَ الْقِبْلَتَــــــــــــــــــــــــــــيْنِ"},
            {"مَنْ رَاٰى وَجْهَــــــــكَ يَسْعَــــــدُ", "يَاكَـــــــــــــرِيْمَ الْــــــــــــــوَالِدَيْنِ"},
            {"حَوْضُكَ الصَّــــــافِى الْمُبَــــــــرَّدُ", "وِرْدُنَا يَوْمَ النُّشُـــــــــــــــــــــوْرِ"},
            {"مَارَأَيْـــــــــنَا الْعِيْسَ حَنَّـــــــــتْ", "بِالسُّـــــــــرٰى إِلاَّ اِلَيْــــــــــــــكَ"},
            {"وَالْغَــــماَمَةْ قَـــــدْ أَظَلَّــــــــــــتْ", "وَالْمَـــــــــلاَ صَــــــــــــــلَّوْعَلَيْكَ"},
            {"وَاَتَاكَ الْعُـــــــــوْدُ يَبْــــــــــــــكِى", "وَتَـــــــــذَلَّلْ بَيْنَ يَــــــــــــــدَيْكَ"},
            {"وَاسْتَجَـــــــــارَتْ يَاحَبِيْــــــــبِي", "عِنْدَكَ الظَّــــــــــبْيُ النُّــــــــفُوْرُ"},
            {"عِنْدَ مَاشَـــــــــدُّوْا الْمَحَامِــــــلْ", "وَتَنَادَوْا لِلـــــــــرَّحِيْـــــــــــــــــلِ"},
            {"جِئْتُهُمْ وَالدَّمْـــــــــعُ سَائِــــــــــلْ", "قُلْـــــــــتُ قِفْ لِى يَادَلِيْــــــــلُ"},
            {"وَتَحَمَّلْ لِيْ رَسَــــــــــــــائِــــــــلْ", "اَيُّهَا الشَّــــــــــــــوْقُ الْجَـــزِيْلُ"},
            {"نَحْوَهَا تِيْـــــــــكَ الْمَنَـــــــــــازِلْ", "بِالْعَشِــــــــيِّ وَالْبُكُــــــــــــــــوْرُ"},
            {"كُلُّ مَـــنْ فِى الْكَـــوْنِ هَامُـــــوْا", "فِيْـــــــــــكَ يَابَاهِى الْجَبِـــــــــيْنِ"},
            {"وَلَهُمْ فِيْــــــــــــكَ غَــــــــــــــرَامُ", "وَاشْـــــــــتِيَاقٌ وَحَنِـــــــــيْنُ"},
            {"فِى مَعَــــــــــــــانِيْــــــــــكَ الْأَنَامُ", "قَدْتَبَدَّتْ حَـــــــــــآئِـــــــــــــرِيْنَ"},
            {"اَنْتَ لِلرُّسْـــــــــلِ خِتَـــــــــــــامُ", "اَنْتَ لِلْمَـــــــــوْلىٰ شَكُـــــــــــوْرُ"},
            {"عَبْدُكَ الْمِسْــــــــكِيْنُ يَرْجُــــــوْ", "فَضْلَكَ الْجَـــــــــمَّ الْغَفِـــــــــــيْرَ"},
            {"فِيْكَ قَدْ أَحْسَـــــــــنْتُ ظَنِّــــيْ", "يَابَشِــــــــــــــيْرُ يَانَــــــــــــــذِيْرُ"},
            {"فَأَغِثْنِيْ وَأَجِـــــــــــــــرْنِـــــــــــيْ", "يَامُجِيْرُ مِنَ السَّــــــــــــــعِــــــيْرِ"},
            {"يَاغِــــــــــــــيَاثِي يَامَـــــــــلاَذِيْ", "فِيْ مُهِمَّاتِ الْأُمُــــــــــــــــــــــوْرِ"},
            {"سَعْدَ عَبْــــــــدٌ قَدْ تَمَــــــــــــلىّٰ", "وَانْجَــــــلىٰ عَنْــــــــــــــهُ الْحَزِيْنُ"},
            {"فِيْكَ يَابَــــــــــــــدْرٌتَجَــــــــــــلىّٰ", "فَلَكَ الْوَصْـــــــــفُ الْحَسِــــــيْنُ"},
            {"لَيْـــــــــسَ أَزْكىٰ مِنْكَ أَصْــــــلاً", "قَـــــــطُّ يَاجَدَّ الْحُــــــــــــــسَيْنِ"},
            {"فَعَلَيْـــــــــكَ اللهُ صَــــــــــــــلىّٰ", "دَآئِماً طُـــــــــوْلَ الدُّهُـــــــــــــوْرِ"},
            {"يَاوَلِيَّ الْحَــــــــــــــسَنَــــــــــاتِ", "يَارَفِيْـــــــــعَ الدَّرَجَـــــــــــــــــاتِ"},
            {"كَفِّرْ عَنِّـــــــي الذُّنُــــــــــــــــوْبَ", "وَاغْـــــــفِرْعَنِّي سَـــــــيِّئَــــــــاتِ"},
            {"أَنْتَ غَـــــــــفَّارُ الْخَـــــــــــطَايَا", "وَالذُّنُوْبِ الْمُـــــــــوْبِقَــــــــــــاتِ"},
            {"أَنْتَ سَـــــــــتَّارُ الْمَسَــــــــاوِيْ", "وَمُقِيْــــــــلُ الْعَــــــــــــــــــثَرَاتِ"},
            {"عَالِــــــــــــــمُ السِّــــــــرِّ وَأَخْفىٰ", "مُسْتَجِيْـــــــــبُ الدَّعَوَاتِ"},
            {"رَبِّ فَارْحَمْـــــــــنَا جَمِيْـــــــــــــعًا", "وَامْحُ عَنَّا السَّـــــــــيِّـــــــــــئَاتِ"},
            {"صَــــــلىّٰ اللهُ عَلىٰ مُحَمَّــــــــــدٍ", "عَــــــــدَّ تَحْرِيْرِ السُطُــــــــــــوْرِ"},
            {"اَحْمَــــــــدَ الْهَادِيْ مُحَمَّـــــــــــدْ", "صَـــــــــاحِبَ الْوَجْهِ الْمُنِــــــــيْرِ"},
            {"رَبِّ فَارْحَمْنَاجَمِيْــــــــــــــــــــــــعًا", "بِجَمِيْعِ الصَّالِحَــــــــــــــــــــــــاتِ"}
        };

        for (String[] row : qiyamData) {
            addQasidahRow(container, row[0], row[1], amiriBold);
        }

        addDivider(container, amiriBold);

        // 7. Title 3: Doa
        addTitle(container, "دُعَاء", amiriBold);

        // 8. Paragraph 3: Doa Text
        String doaText = "اَلْحَمْدُ ِللهِ رَبِّ الْعَالَمِيْنَ • اَللّٰهُمَّ صَلِّ وَسَلِّمْ عَلٰى سَيِّدِنَا مُحَمَّدٍ وَ عَلىٰ اٰلِهٖ وَصَحْبِهٖ أَجْمَعِيْن • جَعَلَنَا اللهُ وَإِيَاكُمْ مِمَّنْ يَسْتَوْجِبُ شَفَاعَتَهُ • وَيَرْجُوْ بِذٰلِكَ رَحْمَتَهُ وَرَأْفَتَهُ • أَللّٰهُمَّ بِحُرْمَةِ هٰذَا النَّبِيِّ الْكَرِيْمِ • وَاٰلِهِ وَأَصْحَابِهِ السَّالِكِيْنَ عَلىٰ مَنْهَجِهِ الْقَوِيْمِ • إِجْعَلْنَا مِنْ خِيَارِ أُمَّتِهٖ • وَاسْتُرْنَا بِذَيْلِ حُرْمَتِهِ • وَاحْشُـرْنَا غَدًا فِيْ زُمْرَتِهِ • وَاسْتَعْمِلْ أَلْسِنَتَنَا فِيْ مَدْحِهٖ وَنُصْـرَتِهِ • وَأَحْيِنَا مُتَمَسِّكِيْنَ بِسُنَّتِهِ وَطَاعَتِهِ • وَأَمِتْنَا عَلىٰ حُبِّهٖ وَجَمَاعَتِهِ • أَللّٰهُمَّ أَدْخِلْنَا مَعَهُ الْجَنَّةَ فَإِنَّهُ أَوَّلُ مَنْ يَدْخُلُهَا • وَأَنْزِلْنَا مَعَهٗ فِيْ قُصُوْرِهَا • فَإِنَّهُ أَوَّلُ مَنْ يَنْزِلُهَا • وَارْحَمْنَا يَوْمَ يَشْفَعُ لِلْخَلَآئِقِ فَتَرْحَمُهَا • أَللّٰهُمَّ ارْزُقْنَا زِيَارَتَهٗ فِيْ كُلِّ سَنَةٍ • وَلاَ تَجْعَلْنَا مِنْ الْغَافِلِيْنَ عَنْكَ وَلاَ عَنْهُ قَدْرَ سِنَةٍ • أَللّٰهُمَّ لاَ تَجْعَلْ فِيْ مَجْلِسِنَا هٰذَا أَحَدًا إِلاَّ غَسَلْتَ بِمَاءِ التَّوْبَةِ ذُنُوْبَهُ • وَسَتَرْتَ بِرِدَآءِ الْمَغْفِرَةِ عُيُوْبَهُ • اَللّٰهُمَّ إِنَّهٗ كَانَ مَعَنَا فِي السَّنَةِ الْمَاضِيَةِ • إِخْوَانٌ مَنَعَهُمُ اْلقَضَآءُ عَنِ الْوُصُوْلِ اِلٰى مِثْلِهَا • فَلاَ تَحْرِمْهُمْ مِنْ ثَوَابِ هٰذِهِ السَّاعَةِ وَفَضْلِهَا • اَللّٰهُمَّ ارْحَمْنَا إِذَا صِرْنَا مِنْ أَصْحَابِ الْقُبُوْرِ • وَوَفِّقْنَا لِعَمَلٍ صَالِحٍ يَبْقٰى سَنَاهُ عَلىٰ مَمَرِّ الدُّهُوْرِ • اَللّٰهُمَّ اجْعَلْنَا لِاٰلَآئِكَ ذَاكِرِيْنَ • وَلِنَعْمَآئِكَ شَاكِرِيْنَ • وَلِيَوْمِ لِقَآئِكَ مِنَ الذَّاكِرِيْنَ • وَأَحْيِنَا بِطَاعَتِكَ مَشْغُوْلِيْنَ • وَإِذَا تَوَفَّيْتَنَا فَتَوَفَّنَا غَيْرَ مَفْتُوْنِيْنَ • وَلاَ مَخْذُوْلِيْنَ • وَٱخْتِمْ لَنَا مِنْكَ بِخَيْرٍ أَجْمَعِيْنَ • اَللّٰهُمَّ اكْفِنَا شَرَّ الظَّالِمِيْنَ • وَاجْعَلْنَا مِنْ فِتْنَةِ هٰذِهِ الدُّنْيَا سَالِمِيْنَ • اَللّٰهُمَّ اجْعَلْ هٰذَا الرَّسُوْلَ الْكَرِيْمَ لَنَا شَفِيْعًا • وَارْزُقْنَا بِهِ يَوْمَ الْقِيَامَةِ مَقَامًا رَفِيْعًا • اَللّٰهُمَّ اسْقِنَا مِنْ حَوْضِ نَبِيِّكَ مُحَمَّدٍ صَلَّى اللهُ عَلَيْهِ وَسَلَّمَ شَرْبَةً هَنِيْئَةً لاَ نَظْمَأُ بَعْدَهَا أَبَدًا • وَاحْشُــرْنَا تَحْتَ لِوَآئِهِ غَدًا • اَللّٰهُمَّ اغْفِرْ لَنَا بِهٖ وَلِاٰبـَآئِنَا وَلِأُمَّهَآتِنَا وَلِمَشَايِخِنَا وَلِمُعَلِّمِيْنَا • وَذَوِي الْحُقُوْقِ عَلَيْنَا وَلِمَنْ أَجْرٰى هٰذَا الْخَيْرَ فِيْ هٰذِهِ السَّاعَةِ • وَلِجَمِيْعِ الْمُؤْمِنِيْنَ وَالْمُؤْمِنَاتِ • وَالْمُسْلِمِيْنَ وَالْمُسْلِمَاتِ • اَلْأَحْيَآءِ مِنْهُمْ وَالْأَمْوَاتِ • إِنَّكَ كَرِيْمٌ مُجِيْبُ الدَّعَوَاتِ • وَقَاضِــــيَ الْحَاجَاتِ • وَغَافِرُ الذُّنُوْبِ وَالْخَطِيْئَاتِ • يَاأَرْحَمَ الرَّاحِمِيْنَ • وَصَلَّى اللهُ عَلىٰ سَيِّدِنَا مُحَمَّدٍ وَعَلىٰ اٰلِهِ وَصَحْبِهٖ وَسَلَّمَ • سُبْحَانَ رَبِّــكَ رَبِّ الْعِزَّةِ عَمَّا يَصِفُوْنَ • وَسَلاَمٌ عَلىٰ الْمُرْسَلِيْنَ • وَالْحَمْدُ ِللهِ رَبِّ الْعَالَمِيْنَ •";
        addParagraph(container, doaText, amiriBold);

        addDivider(container, amiriBold);
    }

    private void addQasidahRow(LinearLayout container, String rightText, String leftText, Typeface typeface) {
    LinearLayout row = new LinearLayout(this);
    row.setOrientation(LinearLayout.HORIZONTAL);
    row.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
    row.setLayoutParams(new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
    ));
    row.setPadding(0, dpToPx(8), 0, dpToPx(2)); // padding atas ditambah, biar teks yg "naik" tidak ketumpuk baris di atasnya
    row.setClipChildren(false);
    row.setClipToPadding(false);

    AppCompatTextView tvLeft = makeQasidahCell(leftText, typeface, Gravity.LEFT);
    LinearLayout.LayoutParams lpLeft = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
    lpLeft.setMargins(dpToPx(8), 0, 0, 0); // gap tengah: 0 + 0 = nempel, tinggal andalkan padding dalam cell
    tvLeft.setLayoutParams(lpLeft);

    AppCompatTextView tvRight = makeQasidahCell(rightText, typeface, Gravity.RIGHT);
    LinearLayout.LayoutParams lpRight = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
    lpRight.setMargins(0, 0, dpToPx(8), 0);
    tvRight.setLayoutParams(lpRight);

    row.addView(tvLeft);
    row.addView(tvRight);
    container.addView(row);
}

private AppCompatTextView makeQasidahCell(String text, Typeface typeface, int gravity) {
    AppCompatTextView tv = new AppCompatTextView(this);
    tv.setTypeface(typeface, Typeface.BOLD);
    tv.setTextColor(Color.BLACK);
    tv.setGravity(gravity | Gravity.CENTER_VERTICAL);
    tv.setIncludeFontPadding(true);
    tv.setPadding(dpToPx(2), dpToPx(10), dpToPx(2), dpToPx(10)); // sedikit padding kiri-kanan biar tidak nempel banget ke tepi kolom lawan
    tv.setSingleLine(true);
    tv.setMaxLines(1);
    tv.setEllipsize(null);
    tv.setText(text);

    TextViewCompat.setAutoSizeTextTypeWithDefaults(tv, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
    TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(tv, 14, 56, 1, TypedValue.COMPLEX_UNIT_SP);

    float stretchFactorY = 1.75f; // dinaikkan dari 1.55f -> teks lebih tinggi
    float stretchFactorX = 1.08f; // baru: teks sedikit lebih lebar

    tv.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            tv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            tv.setPivotY(tv.getHeight()); // stretch tinggi dari dasar, jadi naik ke atas
            tv.setPivotX(gravity == Gravity.LEFT ? 0f : tv.getWidth()); // stretch lebar dari sisi luar kolom, biar mepet ke tengah tidak makin lebar ke arah tengah
            tv.setScaleY(stretchFactorY);
            tv.setScaleX(stretchFactorX);

            // Rata kanan-kiri (justify) via letterSpacing
            android.graphics.Paint paint = tv.getPaint();
            float textWidth = paint.measureText(text);
            int availableWidth = tv.getWidth() - tv.getPaddingLeft() - tv.getPaddingRight();
            // Bagi availableWidth dengan scaleX karena scaleX ikut memperlebar hasil akhir
            float targetWidth = availableWidth / stretchFactorX;
            int charCount = text.length();
            if (charCount > 1 && targetWidth > textWidth) {
                float extraPx = targetWidth - textWidth;
                float extraEm = (extraPx / (charCount - 1)) / tv.getTextSize();
                tv.setLetterSpacing(extraEm);
            }
        }
    });

    return tv;
}

    private void addTitle(LinearLayout container, String titleText, Typeface typeface) {
        TextView tv = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.setMargins(0, dpToPx(12), 0, dpToPx(8));
        tv.setLayoutParams(params);
        tv.setTypeface(typeface, Typeface.BOLD);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
        tv.setTextColor(Color.BLACK);
        tv.setIncludeFontPadding(true);
        tv.setText(titleText);
        tv.setGravity(Gravity.CENTER);
        container.addView(tv);
    }

    private void addBismillah(LinearLayout container, String text, Typeface typeface) {
        TextView tv = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, dpToPx(10), 0, dpToPx(10));
        tv.setLayoutParams(params);
        tv.setTypeface(typeface, Typeface.BOLD);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 38);
        tv.setTextColor(Color.BLACK);
        tv.setIncludeFontPadding(true);
        tv.setText(text);
        tv.setGravity(Gravity.CENTER);
        container.addView(tv);
    }

    private void addParagraph(LinearLayout container, String text, Typeface typeface) {
        TextView tv = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, dpToPx(8), 0, dpToPx(8));
        tv.setLayoutParams(params);
        tv.setTypeface(typeface, Typeface.BOLD);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        tv.setTextColor(Color.BLACK);
        tv.setIncludeFontPadding(true);
        tv.setLineSpacing(dpToPx(4), 1.25f);
        tv.setText(text);
        tv.setGravity(Gravity.CENTER);
        container.addView(tv);
    }

    private void addDivider(LinearLayout container, Typeface typeface) {
        TextView tv = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, dpToPx(8), 0, dpToPx(8));
        tv.setLayoutParams(params);
        tv.setTypeface(typeface, Typeface.BOLD);
        tv.setText("•");
        tv.setTextColor(Color.BLACK);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
        tv.setGravity(Gravity.CENTER);
        container.addView(tv);
    }

    private int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
}
