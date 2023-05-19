package oop.lab03.acme;

public final class Testing {

    private Testing() { }

    public static void main(final String[] args) {
        /*
         * 1) Creare 3 studenti a piacere 
         */
    	
    	final Student tommaso = new Student(1, "Tommaso", "Brini", "tommasob", 2019);
    	final Student luigi = new Student(2, "Luigi", "Borriello", "luigib", 2019);
    	final Student gustavo = new Student(3, "Gustavo", "Mazzanti", "gustavom", 2019);
    	
        /* 
         * 2) Creare 2 docenti a piacere
         */ 
          
        final Professor ghini = new Professor(10, "Vittorio", "Ghini", "tuamamma", new String[] {"SO", "MDP"}); 
        final Professor viroli = new Professor(11, "Mirko", "Viroli", "java", new String[] {"OOP", "RETI"});
         
        /* 
         * 3) Creare due aulee di esame, una con 100 posti una con 80 posti
         */ 
         
        final ExamRoom vela = new ExamRoom(100, "VELA", true, true);
        final ExamRoom gpt1 = new ExamRoom(80, "GPT1", true, true);
        
        /*
         *  4) Creare due esami, uno con nMaxStudents=10, l'altro con nMaxStudents=2
         */
        
        final Exam oop = new Exam(10, 10, viroli.getCourses()[0], viroli, vela);
        final Exam so = new Exam(11, 2, ghini.getCourses()[0], ghini, gpt1);
        
        /*  
         * 5) Iscrivere tutti e 3 gli studenti agli esami 
         */
         
        oop.registerStudent(tommaso);
        oop.registerStudent(luigi);
        oop.registerStudent(gustavo);
        
        so.registerStudent(tommaso);
        so.registerStudent(luigi);
        so.registerStudent(gustavo);
     
        /* 
         * 6) Stampare in stdout la rapresentazione in stringa dei due esami
         */
        
        System.out.println(oop.toString());
        System.out.println(so.toString());
        
    }
}
