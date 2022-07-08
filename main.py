# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
import random, time


def main():
    success = 0
    failure = 0
    for i in range(0,100000):
        if i % 10000 == 0:
            print("Run: " + str(i))
        testRun = prison(100)
        if testRun.success:
            success += 1
        else:
            failure += 1
    print("Success: " + str(success) + " Failure: " + str(failure))


class prison(object):
    """A single run of the prison"""

    def __init__(self,size):
        self.boxLabel = range(1,size+1)
        self.boxCont = [0]
        self.success = True
        self.size = size
        for i in self.boxLabel:
            while True:
                n = random.randint(1,size)
                if not n in self.boxCont:
                    self.boxCont.append(n)
                    break
        for i in range(1,size+1):
            pR = self.prisonerRun(i)
            if pR > size/2:
                self.success = False
                break


    def prisonerRun(self,n):
        currentNumber = n
        tries = 0
        while True:
            tries += 1
            #if tries > self.size/2:
            #    return self.size

            #DEBUG
            #print(str(tries) + " " + str(n) + " " + str(currentNumber) + " " + str(self.boxCont[currentNumber]))

            if self.boxCont[currentNumber] == n:
                return tries
            else:
                currentNumber = self.boxCont[currentNumber]


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    start_time = time.time()
    main()
    print("--- %s seconds ---" % (time.time() - start_time))

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
