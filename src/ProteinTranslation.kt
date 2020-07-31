/**
 * # Protein Translation

Translate RNA sequences into proteins.

RNA can be broken into three nucleotide sequences called codons, and then translated to a polypeptide like so:

RNA: `"AUGUUUUCU"` => translates to

Codons: `"AUG", "UUU", "UCU"`
=> which become a polypeptide with the following sequence =>

Protein: `"Methionine", "Phenylalanine", "Serine"`

There are 64 codons which in turn correspond to 20 amino acids; however, all of the codon sequences and resulting amino acids are not important in this exercise.  If it works for one codon, the program should work for all of them.
However, feel free to expand the list in the test suite to include them all.

There are also three terminating codons (also known as 'STOP' codons); if any of these codons are encountered (by the ribosome), all translation ends and the protein is terminated.

All subsequent codons after are ignored, like this:

RNA: `"AUGUUUUCUUAAAUG"` =>

Codons: `"AUG", "UUU", "UCU", "UAA", "AUG"` =>

Protein: `"Methionine", "Phenylalanine", "Serine"`

Note the stop codon `"UAA"` terminates the translation and the final methionine is not translated into the protein sequence.

Below are the codons and resulting Amino Acids needed for the exercise.

Codon                 | Protein
:---                  | :---
AUG                   | Methionine
UUU, UUC              | Phenylalanine
UUA, UUG              | Leucine
UCU, UCC, UCA, UCG    | Serine
UAU, UAC              | Tyrosine
UGU, UGC              | Cysteine
UGG                   | Tryptophan
UAA, UAG, UGA         | STOP

 *
 */
fun main(){
val rnaSequence="AUGUUUUCU"
    val stopCodons = listOf("UAA","UAG","UGA")

    loop@ for (s in provideCodonList(rnaSequence)) {
        when {
            s.equals("AUG",ignoreCase = true) -> {
                println("Methionine")
            }
            s.equals("UUU",ignoreCase = true) or s.equals("UUC",ignoreCase = true) -> {
                println("Phenylalanine")
            }
            s.equals("UUA",ignoreCase = true) or s.equals("UUG",ignoreCase = true) -> {
                println("Leucine")
            }
            s.equals("UCU",ignoreCase = true) or
                    s.equals("UCC",ignoreCase = true) or s.equals("UCA",ignoreCase = true) or
                    s.equals("UCG",ignoreCase = true) -> {
                println("Serine")
            }
            s.equals("UAU",ignoreCase = true) or s.equals("UAC",ignoreCase = true) -> {
                println("Tyrosine")
            }
            s.equals("UGG",ignoreCase = true) -> {
                println("Tryptophan")
            }
            s.equals("UGU",ignoreCase = true) or s.equals("UGC",ignoreCase = true) -> {
                println("Cysteine")
            }
            s in stopCodons -> break@loop
        }
    }


}


fun provideCodonList(rnaSequence:String):List<String>{
    val codonsList = mutableListOf<String>()
    var startIndex=0
    var endIndex=3
    // use string.length to prevent breaking of the code
    for (i in 0..rnaSequence.length){
        val condons=rnaSequence.subSequence(startIndex, endIndex)
        codonsList.add(condons as String)
        startIndex=endIndex
        endIndex+=3
        if (endIndex>rnaSequence.length) break
    }
    return codonsList
}