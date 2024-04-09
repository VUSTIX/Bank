package com.example.bank


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bank.data.Card
import com.example.bank.ui.theme.BlueEnd
import com.example.bank.ui.theme.BlueStart
import com.example.bank.ui.theme.GreenEnd
import com.example.bank.ui.theme.GreenStart
import com.example.bank.ui.theme.OrangeEnd
import com.example.bank.ui.theme.OrangeStart
import com.example.bank.ui.theme.PurpleEnd
import com.example.bank.ui.theme.PurpleStart
import org.w3c.dom.Text

val cards = listOf(
    
    Card(
        cardType = "VISA",
        cardNumber = "1234 5678 1234 5678",
        cardName = "Business",
        balance = 46.467,
        color = getGradient(startColor = PurpleStart, endColor = PurpleEnd),
    ),

    Card(
        cardType = "MASTER CARD",
        cardNumber = "5247 0342 2783 9432",
        cardName = "Saving",
        balance = 523.34,
        color = getGradient(startColor = BlueStart, endColor = BlueEnd),
    ),
    
    Card(
        cardType = "MASTER CARD",
        cardNumber = "7458 5391 6472 8789",
        cardName = "School",
        balance = 30.95,
        color = getGradient(startColor = OrangeStart, endColor = OrangeEnd),
    ),
    
    Card(
        cardType = "VISA",
        cardNumber = "3561 6723 3576 4831",
        cardName = "Trips",
        balance = 215.342,
        color = getGradient(startColor = GreenStart, endColor = GreenEnd),
    )
    
    
)

fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Composable
fun CardsSection() {
    LazyRow { 
        items(cards.size) { index ->
            CardItem(index)
        }
    }
}


@Composable
fun CardItem(
    index: Int
) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if(index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)
    if(card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(12.dp, 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}