package experiments

import GA

fun main() {
    val mutationTypes = arrayOf(
        Individual.MutationType.INSERTION,
        Individual.MutationType.SCRAMBLE,
        Individual.MutationType.SCRAMBLE_INSERTION
    )
    val crossoverTypes = arrayOf(CrossoverType.ONE_POINT, CrossoverType.UNIFORM)
    val crossoverRates = arrayOf(0.9, 1.0)
    val mutationRates = arrayOf(0.1, 0.0)

    RandomEngine.seed = 4

    for (crossType in crossoverTypes) {
        for (mutType in mutationTypes) {
            for (mutRate in mutationRates) {
                for (crossRate in crossoverRates) {
                    for(original in arrayOf(true, false)) {
                        for(tournamentSelectionType in GA.TournamentSelectionType.values()) {
                            Thread(Runnable {
                                GA(
                                    encryptedString = ex1str,
                                    maxKeySize = 8,
                                    popSize = 1000,
                                    maxGen = 300,
                                    testAppendId = "ex1_${crossType}_${mutType}_${mutRate}_${crossRate}_${original}_${tournamentSelectionType}",
                                    crossoverType = crossType,
                                    mutationType = mutType,
                                    origMutationRate = mutRate,
                                    crossOverRate = crossRate,
                                    selectionSampleSize = 3,
                                    monogram = true,
                                    bigram = !original,
                                    trigram = !original,
                                    quadgram = !original,
                                    quintgram = !original,
                                    tournamentSelectionType = tournamentSelectionType
                                    ).getDecryptionKey()
                            }).start()
                            Thread(Runnable {
                                GA(
                                    encryptedString = ex2str,
                                    maxKeySize = 8,
                                    popSize = 1000,
                                    maxGen = 300,
                                    testAppendId = "ex2_${crossType}_${mutType}_${mutRate}_${crossRate}_${original}_${tournamentSelectionType}",
                                            crossoverType = crossType,
                                    mutationType = mutType,
                                    origMutationRate = mutRate,
                                    crossOverRate = crossRate,
                                    selectionSampleSize = 3,
                                    monogram = true,
                                    bigram = !original,
                                    trigram = !original,
                                    quadgram = !original,
                                    quintgram = !original,
                                    tournamentSelectionType = tournamentSelectionType
                                ).getDecryptionKey()
                            }).start()
                            Thread(Runnable {
                                GA(
                                    encryptedString = ex3str,
                                    maxKeySize = 26,
                                    popSize = 1000,
                                    maxGen = 300,
                                    testAppendId = "ex3_${crossType}_${mutType}_${mutRate}_${crossRate}_${original}_${tournamentSelectionType}",
                                    crossoverType = crossType,
                                    mutationType = mutType,
                                    origMutationRate = mutRate,
                                    crossOverRate = crossRate,
                                    selectionSampleSize = 3,
                                    monogram = true,
                                    bigram = !original,
                                    trigram = !original,
                                    quadgram = !original,
                                    quintgram = !original,
                                    tournamentSelectionType = tournamentSelectionType
                                ).getDecryptionKey()
                            }).start()
                            Thread(Runnable {
                                GA(
                                    encryptedString = ex4str,
                                    maxKeySize = 40,
                                    popSize = 1000,
                                    maxGen = 300,
                                    testAppendId = "ex4_${crossType}_${mutType}_${mutRate}_${crossRate}_${original}_${tournamentSelectionType}",
                                    crossoverType = crossType,
                                    mutationType = mutType,
                                    origMutationRate = mutRate,
                                    crossOverRate = crossRate,
                                    selectionSampleSize = 3,
                                    monogram = true,
                                    bigram = !original,
                                    trigram = !original,
                                    quadgram = !original,
                                    quintgram = !original,
                                    tournamentSelectionType = tournamentSelectionType
                                ).getDecryptionKey()
                            }).start()
                        }
                    }
                }
            }
        }
    }
}