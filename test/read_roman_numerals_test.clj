(ns read_roman_numerals_test
  (:use clojure.test)
  (:use read_roman_numerals))

(deftest test-1
  (is (= 14 (read-roman-numeral "XIV"))))

(deftest test-2
  (is (= 827 (read-roman-numeral "DCCCXXVII"))))

(deftest test-3
  (is (= 3999 (read-roman-numeral "MMMCMXCIX"))))

(deftest test-4
  (is (= 48 (read-roman-numeral "XLVIII"))))


(run-tests 'read_roman_numerals_test)