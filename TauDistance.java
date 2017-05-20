import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.MultiValuedMap;

import java.util.*;

//Kendall Tau Distance computer, still a work in progress
public class TauDistance {
    static MultiValuedMap<Integer, Integer> aPairs = new MultiValuedMap<Integer, Integer>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object o) {
            return false;
        }

        @Override
        public boolean containsValue(Object o) {
            return false;
        }

        @Override
        public boolean containsMapping(Object o, Object o1) {
            return false;
        }

        @Override
        public Collection<Integer> get(Integer integer) {
            return null;
        }

        @Override
        public boolean put(Integer integer, Integer integer2) {
            return false;
        }

        @Override
        public boolean putAll(Integer integer, Iterable<? extends Integer> iterable) {
            return false;
        }

        @Override
        public boolean putAll(Map<? extends Integer, ? extends Integer> map) {
            return false;
        }

        @Override
        public boolean putAll(MultiValuedMap<? extends Integer, ? extends Integer> multiValuedMap) {
            return false;
        }

        @Override
        public Collection<Integer> remove(Object o) {
            return null;
        }

        @Override
        public boolean removeMapping(Object o, Object o1) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Collection<Map.Entry<Integer, Integer>> entries() {
            return null;
        }

        @Override
        public MultiSet<Integer> keys() {
            return null;
        }

        @Override
        public Set<Integer> keySet() {
            return null;
        }

        @Override
        public Collection<Integer> values() {
            return null;
        }

        @Override
        public Map<Integer, Collection<Integer>> asMap() {
            return null;
        }

        @Override
        public MapIterator<Integer, Integer> mapIterator() {
            return null;
        }
    };
    MultiValuedMap<Integer, Integer> bPairs = new MultiValuedMap<Integer, Integer>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object o) {
            return false;
        }

        @Override
        public boolean containsValue(Object o) {
            return false;
        }

        @Override
        public boolean containsMapping(Object o, Object o1) {
            return false;
        }

        @Override
        public Collection<Integer> get(Integer integer) {
            return null;
        }

        @Override
        public boolean put(Integer integer, Integer integer2) {
            return false;
        }

        @Override
        public boolean putAll(Integer integer, Iterable<? extends Integer> iterable) {
            return false;
        }

        @Override
        public boolean putAll(Map<? extends Integer, ? extends Integer> map) {
            return false;
        }

        @Override
        public boolean putAll(MultiValuedMap<? extends Integer, ? extends Integer> multiValuedMap) {
            return false;
        }

        @Override
        public Collection<Integer> remove(Object o) {
            return null;
        }

        @Override
        public boolean removeMapping(Object o, Object o1) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Collection<Map.Entry<Integer, Integer>> entries() {
            return null;
        }

        @Override
        public MultiSet<Integer> keys() {
            return null;
        }

        @Override
        public Set<Integer> keySet() {
            return null;
        }

        @Override
        public Collection<Integer> values() {
            return null;
        }

        @Override
        public Map<Integer, Collection<Integer>> asMap() {
            return null;
        }

        @Override
        public MapIterator<Integer, Integer> mapIterator() {
            return null;
        }
    };
    static Scanner scan = new Scanner(System.in);
    static int[] a = new int[4];
    static int[] b = new int[4];
    static int position1 = 0;
    static int position2 = 0;
    static int distance = 0;

    public static void distanceA(int[] a) {
        for (int i = 0; i < a.length; i++) {
            position1 = i;
            for (int j = 0; j < a.length; j++) {
                switch (a[j]) {
                    case 0:
                        position2 = a[j];
                        break;
                    case 1:
                        position2 = a[j];
                        break;
                    case 2:
                        position2 = a[j];
                        break;
                    case 3:
                        position2 = a[j];
                        break;
                    case 4:
                        position2 = a[j];
                        break;
                }
                distance = position1 - position2;
                aPairs.put(a[i], distance);
                distance = position1 = position2 = 0;
            }
        }
    }




    public static void main(String[] args){
        System.out.println("Enter numbers 0-4 in any order with a space in between them.");
        for (int i = 0; i < a.length; i++) {
            a[i] = scan.nextInt();
        }
        System.out.println("Now do it again.");
        for (int i = 0; i < b.length; i++) {
            b[i] = scan.nextInt();
        }
        distanceA(a);

    }
}
