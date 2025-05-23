package com.example.minip_footscout.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "players")
data class Player(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val born: Double,
    val nation: String,
    val age: Double,
    val squad: String,
    val league: String,
    val position: String,
    val playingTimeMP: Double,
    val playingTimeStarts: Double,
    val playingTimeMin: Double,
    val playingTime90s: Double,
    val goals: Double,
    val assists: Double,
    val goalsAssists: Double,
    val nonPenaltyGoals: Double,
    val penaltyGoals: Double,
    val penaltyKicked: Double,
    val yellowCards: Double,
    val redCards: Double,
    val xG: Double,
    val nonPenaltyXG: Double,
    val xAG: Double,
    val npxGxAG: Double,
    val progressiveCarries: Double,
    val progressivePasses: Double,
    val progressivePassesReceived: Double,
    val tackles: Double,
    val tacklesWon: Double,
    val tacklesDef3rd: Double,
    val tacklesMid3rd: Double,
    val tacklesAtt3rd: Double,
    val dribblersTackled: Double,
    val dribblesChallenged: Double,
    val dribblersTackledPercentage: Double,
    val challengesLost: Double,
    val blocks: Double,
    val shotsBlocked: Double,
    val passesBlocked: Double,
    val interceptions: Double,
    val tacklesInterceptions: Double,
    val clearances: Double,
    val errors: Double,
    val foulsCommitted: Double,
    val foulsDrawn: Double,
    val offsides: Double,
    val crosses: Double,
    val pkWon: Double,
    val pkConceded: Double,
    val ownGoals: Double,
    val ballRecoveries: Double,
    val aerialDuelsWon: Double,
    val aerialDuelsLost: Double,
    val aerialDuelsWonPercentage: Double,
    val passesCompleted: Double,
    val passesAttempted: Double,
    val passCompletionPercentage: Double,
    val totalPassingDistance: Double,
    val progressivePassingDistance: Double,
    val shortPassesCompleted: Double,
    val shortPassesAttempted: Double,
    val shortPassCompletionPercentage: Double,
    val mediumPassesCompleted: Double,
    val mediumPassesAttempted: Double,
    val mediumPassCompletionPercentage: Double,
    val longPassesCompleted: Double,
    val longPassesAttempted: Double,
    val longPassCompletionPercentage: Double,
    val xA: Double,
    val aMinusXag: Double,
    val keyPasses: Double,
    val passesFinal3rd: Double,
    val passesPenaltyArea: Double,
    val crossesPenaltyArea: Double,
    val touches: Double,
    val touchesDefPen: Double,
    val touchesDef3rd: Double,
    val touchesMid3rd: Double,
    val touchesAtt3rd: Double,
    val touchesAttPen: Double,
    val touchesLiveBall: Double,
    val takeOnsAttempted: Double,
    val takeOnsSuccessful: Double,
    val takeOnsSuccessfulPercentage: Double,
    val takeOnsTackled: Double,
    val takeOnsTackledPercentage: Double,
    val carries: Double,
    val totalCarryingDistance: Double,
    val progressiveCarryingDistance: Double,
    val progressiveCarries2:Double,
    val carriesFinal3rd: Double,
    val carriesPenaltyArea: Double,
    val miscontrols: Double,
    val dispossessed: Double,
    val passesReceived: Double,
   val  progressivePassesReceived2:Double,
    val goalsAgainst: Double,
    val shotsOnTargetAgainst: Double,
    val saves: Double,
    val savePercentage: Double,
    val cleanSheets: Double,
    val cleanSheetPercentage: Double,
    val penaltyKicksSaved: Double,
    val penaltyKicksSavePercentage: Double
)