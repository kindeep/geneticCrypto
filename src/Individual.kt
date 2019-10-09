class Individual {

    var chromosome: CharArray

    constructor(chromosome: CharArray) {
        this.chromosome = chromosome
    }

    constructor(chromosomeString: String) {
        this.chromosome = chromosomeString.toCharArray()
    }

    constructor(chromosomeSize: Int) {
        chromosome = CharArray(chromosomeSize)
        for (i in 0 until chromosomeSize) {
            chromosome[i] = ((97..122) + 45).random().toChar()
        }
    }

    fun getChromosomeString(): String {
        return chromosome.joinToString("")
    }

    fun chromosomeSize(): Int {
        return chromosome.size
    }
}

fun onePointCrossover(indiv1: Individual, indiv2: Individual): List<Individual> {

    val chromosomeSize = indiv1.chromosomeSize()
    val crossoverPoint = (0..indiv1.chromosomeSize()).random()

    val child1 = Individual(indiv1.getChromosomeString())
    val child2 = Individual(indiv2.getChromosomeString())

    val result = ArrayList<Individual>(2)

//    println("Indiv1 " + indiv1.getChromosomeString())
//    println("Indiv2 " + indiv2.getChromosomeString())
//    println("Coitus with ${crossoverPoint}")
    for (i in crossoverPoint until chromosomeSize) {
        // swap chromosome vals at i
        indiv1.chromosome[i] = indiv2.chromosome[i].also { indiv2.chromosome[i] = indiv1.chromosome[i] }
    }
//    println("Indiv1 " + indiv1.getChromosomeString())
//    println("Indiv2 " + indiv2.getChromosomeString())

    result.add(child1)
    result.add(child2)

    return result

}