package com.example.minip_footscout.database

import android.content.Context
import androidx.room.Room
import com.example.minip_footscout.data.local.database.PlayerDatabase
import com.example.minip_footscout.data.local.entity.Player
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.FileInputStream

object databasehelper {

    private const val DATABASE_NAME = "players"

   fun createDatabase(context: Context): PlayerDatabase {
        val dbFile = context.getDatabasePath(DATABASE_NAME)

        if (!dbFile.exists()) {
            val db = Room.databaseBuilder(
                context,
                PlayerDatabase::class.java,
                DATABASE_NAME
            ).build()

            val fileDescriptor = context.assets.openFd("aggregated_2021_2024_90.csv")
            val csvFile = FileInputStream(fileDescriptor.fileDescriptor).bufferedReader()

            db.runInTransaction {
                csvFile.useLines { lines ->
                    lines.drop(1) // Skip the header row
                        .chunked(500) // Process players in batches of 500
                        .forEach { batch ->
                            val playerList = batch.map { line ->
                                val fields = line.split(",")
                                // Parse the CSV fields and create Player objects
                                Player(
                                    name = fields[0],
                                    born = fields[1].toDouble(),
                                    nation = fields[2],
                                    age = fields[3].toDouble(),
                                    squad = fields[4],
                                    league = fields[5],
                                    position = fields[6],
                                    playingTimeMP = fields[7].toDouble(),
                                    playingTimeStarts = fields[8].toDouble(),
                                    playingTimeMin = fields[9].toDouble(),
                                    playingTime90s = fields[10].toDouble(),
                                    goals = fields[11].toDouble(),
                                    assists = fields[12].toDouble(),
                                    goalsAssists = fields[13].toDouble(),
                                    nonPenaltyGoals = fields[14].toDouble(),
                                    penaltyGoals = fields[15].toDouble(),
                                    penaltyKicked = fields[16].toDouble(),
                                    yellowCards = fields[17].toDouble(),
                                    redCards = fields[18].toDouble(),
                                    xG = fields[19].toDouble(),
                                    nonPenaltyXG = fields[20].toDouble(),
                                    xAG = fields[21].toDouble(),
                                    npxGxAG = fields[22].toDouble(),
                                    progressiveCarries = fields[23].toDouble(),
                                    progressivePasses = fields[24].toDouble(),
                                    progressivePassesReceived = fields[25].toDouble(),
                                    tackles = fields[26].toDouble(),
                                    tacklesWon = fields[27].toDouble(),
                                    tacklesDef3rd = fields[28].toDouble(),
                                    tacklesMid3rd = fields[29].toDouble(),
                                    tacklesAtt3rd = fields[30].toDouble(),
                                    dribblersTackled = fields[31].toDouble(),
                                    dribblesChallenged = fields[32].toDouble(),
                                    dribblersTackledPercentage = fields[33].toDouble(),
                                    challengesLost = fields[34].toDouble(),
                                    blocks = fields[35].toDouble(),
                                    shotsBlocked = fields[36].toDouble(),
                                    passesBlocked = fields[37].toDouble(),
                                    interceptions = fields[38].toDouble(),
                                    tacklesInterceptions = fields[39].toDouble(),
                                    clearances = fields[40].toDouble(),
                                    errors = fields[41].toDouble(),
                                    foulsCommitted = fields[42].toDouble(),
                                    foulsDrawn = fields[43].toDouble(),
                                    offsides = fields[44].toDouble(),
                                    crosses = fields[45].toDouble(),
                                    pkWon = fields[46].toDouble(),
                                    pkConceded = fields[47].toDouble(),
                                    ownGoals = fields[48].toDouble(),
                                    ballRecoveries = fields[49].toDouble(),
                                    aerialDuelsWon = fields[50].toDouble(),
                                    aerialDuelsLost = fields[51].toDouble(),
                                    aerialDuelsWonPercentage = fields[52].toDouble(),
                                    passesCompleted = fields[53].toDouble(),
                                    passesAttempted = fields[54].toDouble(),
                                    passCompletionPercentage = fields[55].toDouble(),
                                    totalPassingDistance = fields[56].toDouble(),
                                    progressivePassingDistance = fields[57].toDouble(),
                                    shortPassesCompleted = fields[58].toDouble(),
                                    shortPassesAttempted = fields[59].toDouble(),
                                    shortPassCompletionPercentage = fields[60].toDouble(),
                                    mediumPassesCompleted = fields[61].toDouble(),
                                    mediumPassesAttempted = fields[62].toDouble(),
                                    mediumPassCompletionPercentage = fields[63].toDouble(),
                                    longPassesCompleted = fields[64].toDouble(),
                                    longPassesAttempted = fields[65].toDouble(),
                                    longPassCompletionPercentage = fields[66].toDouble(),
                                    xA = fields[67].toDouble(),
                                    aMinusXag = fields[68].toDouble(),
                                    keyPasses = fields[69].toDouble(),
                                    passesFinal3rd = fields[70].toDouble(),
                                    passesPenaltyArea = fields[71].toDouble(),
                                    crossesPenaltyArea = fields[72].toDouble(),
                                    touches = fields[73].toDouble(),
                                    touchesDefPen = fields[74].toDouble(),
                                    touchesDef3rd = fields[75].toDouble(),
                                    touchesMid3rd = fields[76].toDouble(),
                                    touchesAtt3rd = fields[77].toDouble(),
                                    touchesAttPen = fields[78].toDouble(),
                                    touchesLiveBall = fields[79].toDouble(),
                                    takeOnsAttempted = fields[80].toDouble(),
                                    takeOnsSuccessful = fields[81].toDouble(),
                                    takeOnsSuccessfulPercentage = fields[82].toDouble(),
                                    takeOnsTackled = fields[83].toDouble(),
                                    takeOnsTackledPercentage = fields[84].toDouble(),
                                    carries = fields[85].toDouble(),
                                    totalCarryingDistance = fields[86].toDouble(),
                                    progressiveCarryingDistance = fields[87].toDouble(),
                                    progressiveCarries2 = fields[88].toDouble(),
                                    carriesFinal3rd = fields[89].toDouble(),
                                    carriesPenaltyArea = fields[90].toDouble(),
                                    miscontrols = fields[91].toDouble(),
                                    dispossessed = fields[92].toDouble(),
                                    passesReceived = fields[93].toDouble(),
                                    progressivePassesReceived2 = fields[94].toDouble(),
                                    goalsAgainst = fields[95].toDouble(),
                                    shotsOnTargetAgainst = fields[96].toDouble(),
                                    saves = fields[97].toDouble(),
                                    savePercentage = fields[98].toDouble(),
                                    cleanSheets = fields[99].toDouble(),
                                    cleanSheetPercentage = fields[100].toDouble(),
                                    penaltyKicksSaved = fields[101].toDouble(),
                                    penaltyKicksSavePercentage = fields[102].toDouble()
                                )

                            }.toList()

                            CoroutineScope(Dispatchers.IO).launch{
                                db.playerDao().insertALL(playerList)
                            }
                        }
                }
            }

            return db
        } else {
            return Room.databaseBuilder(
                context,
                PlayerDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}