package com.example.bankcollection.ui.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bankcollection.ui.model.CreditCard

class CardViewModel : ViewModel() {

    private val _card = MutableLiveData<List<CreditCard>>().apply {
        value = listOf(
            CreditCard("2020 全台各銀行信用卡優惠推薦", "https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E7%B2%BE%E9%81%B8%E6%8E%A8%E8%96%A6", "https://images.contentstack.io/v3/assets/blt4ca32b8be67c85f8/bltc4ca50b8cbdf846f/5e5f541c36ac5164513a2af7/864x160@2x.jpg"),

            CreditCard("【聰明繳稅】2020牌照稅信用卡繳稅哪張有優惠？刷哪張看分期零利率？ 這篇總整理", "https://www.money101.com.tw/blog/%E4%BF%A1%E7%94%A8%E5%8D%A1-%E7%89%8C%E7%85%A7%E7%A8%85-%E5%88%86%E6%9C%9F-%E9%9B%B6%E5%88%A9%E7%8E%87-%E5%85%8D%E6%89%8B%E7%BA%8C%E8%B2%BB", "https://s3-ap-northeast-1.amazonaws.com/cgblogassets/blog/zh_TW/wp-content/uploads/2020/03/2020-%E5%B9%B4%E4%BF%A1%E7%94%A8%E5%8D%A1%E7%B9%B3%E7%89%8C%E7%85%A7%E7%A8%85%E7%9B%B8%E9%97%9C%E6%89%8B%E7%BA%8C%E8%B2%BB%E8%88%87%E5%84%AA%E6%83%A0%E5%BD%99%E6%95%B4.jpg"),

            CreditCard("【懶人包】2020Q2信用卡新戶首刷禮整理✿", "https://www.cardu.com.tw/message/detail.php?mt_pk=57&msg_pk=31982", "https://www.cardu.com.tw/201910/20200413/message/16/UCardu20200413181591.jpg"),

            CreditCard("信用卡》2020年最強刷卡現金回饋排行榜【非業配】 @ 黃大偉理財研究室 :: 痞客邦 ::", "http://davidhuang1219.pixnet.net/blog/post/268905840", "https://pic.pimg.tw/davidhuang1219/1577971700-1122967508.png"),

            CreditCard("[4/1更新] 2020 推薦最佳 \$現金回饋率\$ 刷卡組合(網購/加油/公共費用/外幣/餐廳分別整理比較表)", "https://www.beurlife.com/2016/01/2016.html", "https://2.bp.blogspot.com/-Yr1D8IiO73w/W_K_qYdJeQI/AAAAAAAAUAE/zdSqLm9FuCAVIbEUXK_xPJ0I8tJ5KGfKQCLcBGAs/s1600/credit-combo.jpg")
        )
    }

    val cards: LiveData<List<CreditCard>> = _card
}