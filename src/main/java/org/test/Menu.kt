package org.test

import org.test.animals.*
import java.util.*

class Menu {
    /*public MenuAction getMenuAction() {
        return switch (nextAction) {
            case 1 -> showAllAction;
            case 2-> () -> {
                for (Animal animal: animals) {
                    if (animal instanceof Sheep sheep) {
                        System.out.println(sheep);
                    }
                }
            };
            case 3-> () -> {
                for (Animal animal: animals) {
                    if (animal instanceof Cow cow) {
                        System.out.println(cow);
                    }
                }
            };
            case 4-> () -> {
                for (Animal animal: animals) {
                    if (animal instanceof Pig pig) {
                        System.out.println(pig);
                    }
                }
            };
            case 5-> () -> {
                System.out.println("select animal to add: Cow (C) or Sheep (S) or Pig (P)");
                char aniamlChose = sc.next().charAt(0);
                System.out.println("Set VetID");
                int vetID = sc.nextInt();
                System.out.println("Set ID");
                int animalID = sc.nextInt();
                switch (aniamlChose){
                    case 'C':
                        animals.add(new Cow(String.valueOf(vetID), String.valueOf(animalID)));
                        break;
                    case 'S':
                        animals.add(new Sheep(String.valueOf(vetID), String.valueOf(animalID)));
                        break;
                    case 'P':
                        System.out.println("set mass of Pig");
                        animals.add(new Pig(String.valueOf(vetID), String.valueOf(animalID), sc.nextDouble()));
                }
            };
            case 6->()-> {
                showAllAction.doAction();
                System.out.println("chose \"vetID\" -> 1, \"ID\" -> 2, \"index\" -> 3.");
                int userChose = sc.nextInt();
                Livestock temporary;
                switch (userChose){
                    case 1:
                                            do {
                            System.out.println("write vetID");
                            int userVetID = sc.nextInt();
                            temporary = animals.stream()
                                    .map((a) -> (Livestock) a)
                                    .filter(a -> "a".equals(a.getVetID()))
                                    .findFirst()
                                    .orElse(null);
                        } while  (temporary != null);
                        animals.remove(temporary);
break;
                    case 2:
                        do {
                            System.out.println("write ID");
                            int userID = sc.nextInt();
                            temporary = animals.stream()
                                    .map((a) -> (Livestock) a)
                                    .filter(a -> "a".equals(a.getID()))
                                    .findFirst()
                                    .orElse(null);
                        } while  (temporary != null);
                        animals.remove(temporary);
                        break;
                    case 3:
                        System.out.println("write index number");
                        int userIndex = sc.nextInt();
                        animals.remove(userIndex);
                }
            };

            default -> endProgram;
        };
    }*/ var nextAction = 0
        private set

    fun showMenu() {
        println("1.Wyświetl wszysktkie zwierzęta")
        println("2.Wyświetl wszystkie owce")
        println("3.Wyświetl wszystkie krowy")
        println("4.Wyświetl wszystkie świnie")
        println("5.Dodaj zwierzę")
        println("6.Usuń zwierzę")
    }

    fun setNextAction() {
        nextAction = sc.nextInt()
    }

    val menuAction: MenuAction
        get() = when (nextAction) {
            1 -> showAllAction
            2 -> MenuAction {
                for (animal in Main.animals) {
                    if (animal is Sheep) {
                        println(animal)
                    }
                }
            }

            3 -> MenuAction {
                for (animal in Main.animals) {
                    if (animal is Cow) {
                        println(animal)
                    }
                }
            }

            4 -> MenuAction {
                for (animal in Main.animals) {
                    if (animal is Pig) {
                        println(animal)
                    }
                }
            }

            5 -> MenuAction {
                println("select animal to add: Cow (C) or Sheep (S) or Pig (P)")
                val aniamlChose = sc.next()[0] //konkretny char ze stringa
                println("Set VetID")
                val vetID = sc.nextInt()
                println("Set ID")
                val animalID = sc.nextInt()
                when (aniamlChose) {
                    'C' -> Main.animals.add(Cow(vetID.toString(), animalID.toString()))
                    'S' -> Main.animals.add(Sheep(vetID.toString(), animalID.toString()))
                    'P' -> {
                        println("set mass of Pig")
                        Main.animals.add(Pig(vetID.toString(), animalID.toString(), sc.nextDouble()))
                    }
                }
            }

            6 -> MenuAction {
                showAllAction.doAction()
                println("chose \"vetID\" -> 1, \"ID\" -> 2, \"index\" -> 3.")
                val userChose = sc.nextInt()
                when (userChose) {
                    1 -> {
                        var temporary: Livestock?
                        do {
                            println("write vetID")
                            val userVetID = sc.nextInt()
                            temporary = Main.animals.stream()
                                .map { a: Animal? -> a as Livestock? }
                                .filter { a: Livestock? -> "a" == a!!.vetID }
                                .findFirst()
                                .orElse(null)
                        } while (temporary != null)

                        Main.animals.remove(temporary)
                        do {
                            println("write ID")
                            val userID = sc.nextInt()
                            temporary = Main.animals.stream()
                                .map { a: Animal? -> a as Livestock? }
                                .filter { a: Livestock? -> "a" == a!!.id }
                                .findFirst()
                                .orElse(null)
                        } while (temporary != null)
                        Main.animals.remove(temporary)
                        println("write index number")
                        val userIndex = sc.nextInt()
                        Main.animals.removeAt(userIndex)
                    }

                    2 -> {
                        var temporary: Livestock?
                        do {
                            println("write ID")
                            val userID = sc.nextInt()
                            temporary = Main.animals.stream()
                                .map { a: Animal -> a as Livestock }
                                .filter { a: Livestock -> "a" == a.id }
                                .findFirst()
                                .orElse(null)
                        } while (temporary != null)

                        Main.animals.remove(temporary)
                        println("write index number")
                        val userIndex = sc.nextInt()
                        Main.animals.removeAt(userIndex)
                    }

                    3 -> {
                        println("write index number")
                        val userIndex = sc.nextInt()
                        Main.animals.removeAt(userIndex)
                    }
                }
            }

            else -> endProgram
        }

    //odpowiednik spisów staticów z klasy
    companion object {
        private val sc = Scanner(System.`in`)
        private val showAllAction = MenuAction {
            for (animal in Main.animals) {
                println(animal)
            }
        }

        @JvmField
        val endProgram = MenuAction {}
    }
}
