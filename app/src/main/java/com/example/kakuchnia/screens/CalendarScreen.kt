package com.example.kakuchnia.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakuchnia.components.RecipeCard
import com.example.kakuchnia.ui.theme.KaKuchniaTheme
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun CalendarScreen(modifier: Modifier = Modifier) {
    var currentMonth by remember { mutableStateOf(YearMonth.now()) }
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }

    Column(modifier = modifier.fillMaxWidth()) {
        MonthHeader(
            month = currentMonth,
            onPrevious = { currentMonth = currentMonth.minusMonths(1) },
            onNext = { currentMonth = currentMonth.plusMonths(1) },
        )
        WeekdaysRow()
        MonthGrid(
            month = currentMonth,
            selectedDate = selectedDate,
            onDateClick = { selectedDate = it },
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(mockupRecipes ) { recipe ->
                RecipeCard(recipe) {}
            }
        }
    }
}

@Composable
private fun MonthHeader(
    month: YearMonth,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
) {
    val monthName = month.month.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault())

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextButton(onClick = onPrevious) { Text("<") }
        Text("$monthName ${month.year}")
        TextButton(onClick = onNext) { Text(">") }
    }
}

@Composable
private fun WeekdaysRow() {
    Row(modifier = Modifier.fillMaxWidth()) {
        DayOfWeek.entries.forEach { day ->
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                Text(day.getDisplayName(TextStyle.SHORT, Locale.getDefault()))
            }
        }
    }
}

@Composable
private fun MonthGrid(
    month: YearMonth,
    selectedDate: LocalDate,
    onDateClick: (LocalDate) -> Unit,
) {
    val leadingBlanks = month.atDay(1).dayOfWeek.value - 1 // poniedziałek = 0
    val cells: List<LocalDate?> = buildList {
        repeat(leadingBlanks) { add(null) }
        for (day in 1..month.lengthOfMonth()) add(month.atDay(day))
        while (size % 7 != 0) add(null)
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        cells.chunked(7).forEach { week ->
            Row(modifier = Modifier.fillMaxWidth()) {
                week.forEach { date ->
                    Box(
                        modifier = Modifier.weight(1f).aspectRatio(1f),
                        contentAlignment = Alignment.Center,
                    ) {
                        if (date != null) {
                            DayCell(
                                date = date,
                                isSelected = date == selectedDate,
                                onClick = { onDateClick(date) },
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DayCell(
    date: LocalDate,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val text = if (isSelected) "[${date.dayOfMonth}]" else date.dayOfMonth.toString()
    Text(text = text, modifier = Modifier.clickable(onClick = onClick))
}

@Preview(showBackground = true)
@Composable
fun CalendarScreenPreview() {
    KaKuchniaTheme {
        CalendarScreen()
    }
}