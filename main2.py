import random, time


def main():
    success = 0
    failure = 0
    for i in range(0,100):
        testRun = prison(100)
        if testRun.success:
            success += 1
        else:
            failure += 1
    print("Success: " + str(success) + " Failure: " + str(failure))

class prison(object):
    def __init__(self,size):
        self.boxes = []
        self.picker = []
        self.success = True

        for i in range(0,size):
            self.picker.append(i)

        for i in range(0,size):
            self.boxes.append([i])
            #c = True

            n = random.randint(0,len(self.picker)-1)
            self.boxes[i].append(self.picker.pop(n))

        #Offset by 5
        #print(self.boxes)
        offset = 5
        """for i in self.boxes:
            if i[0] < size-offset:
                i[0] += offset
            else:
                i[0] = i[0]-size+offset"""
        for i in range(0,offset):
            self.boxes.insert(0,self.boxes.pop(size-offset+i))
        #print(self.boxes)

        for i in range(0,size):
            pR = self.prisonRun(i)
            if pR > size/2:
                self.success = False
                break

    def prisonRun(self,n):
        currentNumber = n
        tries = 0
        while True:
            tries += 1
            if self.boxes[currentNumber][1] == n:
                return tries
            else:
                currentNumber = self.boxes[currentNumber][1]





if __name__ == '__main__':
    start_time = time.time()
    main()
    print("--- %s seconds ---" % (time.time() - start_time))