package org.test.animals

/**
 * słowo kluczowe var (zmienna) i val (stała) określa pole klasy, w przeciwnym wypadku wartość zostaje "zapomniana" po stworzeniu obiektu
 */
class Cow(vetID: String?, ID: String?) : Livestock(vetID, ID) {

    /**
    @Override
    public String makeASound() {
        return "Muu";
    }
     */
    /**
     * zamiast  adnotacji @Override słowo kluczowe "override"
     * fun (zabawa, function) określenie sitnienia funkcji
     * : Typ -> określenie zwracanego typu
     */
    override fun makeASound(): String {
        return "Mooo"
    }

    override fun toString(): String {
        return super.toString()
    }
}

