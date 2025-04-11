package Session4.Q3;

import java.util.Stack;

class OrganicCompound {
    private String compound;

    public OrganicCompound(String compound) {
        this.compound = compound.toUpperCase();
    }

    public String getCompound() {
        return compound;
    }

    boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int atomicMass() {
        try {
            Stack<String> atomicStack = new Stack<String>();
            String[] atoms = compound.split("");
            int valid = 0;
            for (String atom : atoms) {
                if(!(isNumber(atom) || atom.equals("C") || atom.equals("H") || atom.equals("O") || atom.equals("(") || atom.equals(")"))) {
                    return -1;
                }
                if(atom == "(") {
                    valid++;
                } else if(atom == ")") {
                    valid--;
                }
            }
            if(valid != 0) return -1;
            for (int index=0; index<atoms.length; index++) {
                switch (atoms[index]) {
                    case "(":
                        atomicStack.add("(");
                        break;
                
                    case ")":
                        int value = 0;
                        int num = 1;
                        index=index+1;
                        while(index < atoms.length && isNumber(atoms[index]) && (Integer.parseInt(atoms[index]) >= 0 && Integer.parseInt(atoms[index]) <= 9)) {
                            num = num*10 + Integer.parseInt(atoms[index]);
                            index++;
                        }
                        index--;
                        while(atomicStack.peek() != "(") {
                            value += Integer.parseInt(atomicStack.pop());
                        }
                        atomicStack.pop();
                        atomicStack.push(Integer.toString(value * num));
                        break;
                
                    case "C":
                        atomicStack.add("12");
                        break;
                
                    case "O":
                        atomicStack.add("16");
                        break;
                
                    case "H":
                        atomicStack.add("1");
                        break;
                
                    case "0":
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                    case "9":
                        num = 0;
                        while(index < atoms.length && isNumber(atoms[index]) && (Integer.parseInt(atoms[index]) >= 0 && Integer.parseInt(atoms[index]) <= 9)) {
                            num = num*10 + Integer.parseInt(atoms[index]);
                            index++;
                        }
                        index--;
                        atomicStack.add(Integer.toString(Integer.parseInt(atomicStack.pop()) * num));
                        break;
                
                    default:
                        System.out.println("Invalid character : '" + atoms[index] + "'");
                        break;
                }
            }
            int result = 0;
            while(!atomicStack.isEmpty()) {
                result += Integer.parseInt(atomicStack.pop());
            }
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}

public class Q3 {
    public static void main(String[] args) {
        OrganicCompound comp = new OrganicCompound("C(H3)");
        if(comp.atomicMass() == -1) {
            System.out.println("Invalid input!");
            return;
        }
        System.out.println("Atomic mass for " + comp.getCompound() +  " is: " +comp.atomicMass());
    }
}