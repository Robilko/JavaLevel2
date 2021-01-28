package Java_2_AdvancedLevel.lesson1;

//        1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
//        Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о
//        действии в консоль).
//        2. Создайте два класса: беговая дорожка и стена, при прохождении через которые,
//        участники должны выполнять соответствующие действия (бежать или прыгать),
//        результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.
//        д.). У препятствий есть длина (для дорожки) или высота (для стены), а участников
//        ограничения на бег и прыжки.
//        3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников
//        пройти этот набор препятствий. Если участник не смог пройти одно из препятствий, то
//        дальше по списку он препятствий не идет.

public  class Main {
    public static void main(String[] args) {

        int countMembers = 4;  //кол-во участников марафона каждого класса (кот, человек, робот)
        int countEquipments = 10; // кол-во снаярядов в марафоне
        startMarathon(countMembers, countEquipments);
    }

    public static Run[][] arrayOfMembers (int count) {
        Run[][] array = new  Run[3][count];
        for (int i = 0; i < count; i++) {
            array[0][i] = new Cat();
            array[1][i] = new Human();
            array[2][i] = new Robot();
        }
        return array;
    }

    public static Equipment[] arrayOfEquipments(int count) {
        Equipment[] array = new Equipment[count * 2];
        for (int i = 0; i < count; i++){
            array[i] = new Wall();
            array[++i] = new Treadmill();
        }
        return array;
    }

    public static void startMarathon(int countMembers, int countEquipments) {
        Run[][] runMembers = arrayOfMembers(countMembers);  //создаем и заполняем массив с участниками марафона
        Equipment[] marathon = arrayOfEquipments(countEquipments); // создаем и заполняем массив со спортивными снарядами

        for (int i = 0; i < countMembers; i++) {
            for (int j = 0; j < runMembers.length; j++) {
                Run runner = runMembers[j][i];
                Jump jumper = (Jump)runMembers[j][i];

                for (Equipment equipment : marathon) {
                    if ( equipment instanceof Wall) {
                        if(equipment.action(jumper)) {
                            System.out.println("Барьер высотой " + String.format("%.2f", equipment.height) + " единиц пройден успешно!");
                        } else {
                            System.out.println("Прыгун не справился с барьером высотой " + String.format("%.2f", equipment.height) + " единиц и выбывет из марафона");
                            break;
                        }
                    } else if (equipment instanceof Treadmill) {
                        if(equipment.action(runner)) {
                            System.out.println("Дистанция в " + String.format("%.2f", equipment.distance) + " единиц пройдена успешно!");
                        } else {
                            System.out.println("Бегун не справился с дистанцией длинной " + String.format("%.2f", equipment.distance) + " единиц и выбывает из марафона");
                            break;
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}